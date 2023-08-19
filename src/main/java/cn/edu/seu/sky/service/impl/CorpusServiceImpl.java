package cn.edu.seu.sky.service.impl;

import cn.edu.seu.sky.base.PageResult;
import cn.edu.seu.sky.entity.Corpus;
import cn.edu.seu.sky.enums.CorpusStatus;
import cn.edu.seu.sky.mapper.CorpusMapper;
import cn.edu.seu.sky.service.CorpusService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaotian on 2023/8/13
 */
@Service
public class CorpusServiceImpl extends ServiceImpl<CorpusMapper, Corpus> implements CorpusService {

    @Override
    public PageResult<Corpus> pageQuery(int pageNum, int pageSize) {
        LambdaUpdateWrapper<Corpus> wrapper = Wrappers.<Corpus>lambdaUpdate().eq(Corpus::getStatus, 0);
        Page<Corpus> page = this.page(Page.of(pageNum, pageSize), wrapper);
        return PageResult.of(page, Corpus::new);
    }

    @Override
    public void updateProcessedByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        List<Corpus> list = ids.stream().map(id -> {
            Corpus corpus = new Corpus();
            corpus.setId(id);
            corpus.setStatus(CorpusStatus.PROCESSED.getValue());
            return corpus;
        }).collect(Collectors.toList());
        this.updateBatchById(list);
    }
}
