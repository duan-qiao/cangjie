package cn.edu.seu.sky.service.impl;

import cn.edu.seu.sky.base.PageResult;
import cn.edu.seu.sky.entity.Corpus;
import cn.edu.seu.sky.service.DictService;
import cn.edu.seu.sky.service.CorpusService;
import cn.edu.seu.sky.service.TokenizerService;
import cn.edu.seu.sky.utils.JiebaUtil;
import cn.edu.seu.sky.vo.Token;
import cn.edu.seu.sky.vo.Tokenization;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaotian on 2023/8/15
 */
@Service
public class TokenizerServiceImpl implements TokenizerService {

    @Resource
    public CorpusService corpusService;

    @Resource
    public DictService dictService;

    @Override
    public PageResult<Tokenization> pageQuery(int pageNum, int pageSize) {
        PageResult<Corpus> pageResult = corpusService.pageQuery(pageNum, pageSize);
        List<Tokenization> results = pageResult.getList().stream().map(corpus -> {
            Tokenization tokenization = new Tokenization();
            tokenization.setId(corpus.getId());
            tokenization.setSentence(corpus.getSentence());
            tokenization.setTokens(JiebaUtil.handle(corpus.getSentence()));
            return tokenization;
        }).collect(Collectors.toList());
        return PageResult.of(pageResult, results);
    }

    @Override
    @Transactional
    public boolean save(List<Tokenization> list) {
        List<String> words = list.stream()
                .map(Tokenization::getTokens)
                .flatMap(Collection::stream)
                .map(Token::getWord)
                .collect(Collectors.toList());
        dictService.batchSave(words);

        List<Long> ids = list.stream().map(Tokenization::getId).collect(Collectors.toList());
        corpusService.updateProcessedByIds(ids);
        return true;
    }
}
