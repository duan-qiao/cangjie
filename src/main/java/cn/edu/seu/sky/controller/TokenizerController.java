package cn.edu.seu.sky.controller;

import cn.edu.seu.sky.base.BaseResult;
import cn.edu.seu.sky.base.PageResult;
import cn.edu.seu.sky.service.TokenizerService;
import cn.edu.seu.sky.vo.Tokenization;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiaotian on 2023/8/15
 */
@RestController
@RequestMapping("tokenizer")
public class TokenizerController {

    @Resource
    public TokenizerService tokenizerService;

    @GetMapping("page")
    public BaseResult<PageResult<Tokenization>> page(int pageNum, int pageSize) {
        return BaseResult.success(tokenizerService.pageQuery(pageNum, pageSize));
    }

    @PostMapping("save")
    public BaseResult<Void> save(@RequestBody List<Tokenization> list) {
        return BaseResult.result(tokenizerService.save(list));
    }
}
