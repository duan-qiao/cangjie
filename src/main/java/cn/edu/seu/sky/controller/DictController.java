package cn.edu.seu.sky.controller;

import cn.edu.seu.sky.base.BaseResult;
import cn.edu.seu.sky.entity.Dict;
import cn.edu.seu.sky.service.DictService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiaotian on 2023/8/13
 */
@RestController
@RequestMapping("dict")
public class DictController {

    @Resource
    public DictService dictService;

    @GetMapping("queryOne")
    public BaseResult<Dict> queryOne(String word) {
        return BaseResult.success(dictService.queryOne(word));
    }
}
