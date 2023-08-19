package cn.edu.seu.sky.service;

import cn.edu.seu.sky.base.PageResult;
import cn.edu.seu.sky.vo.Tokenization;

import java.util.List;

/**
 * @author xiaotian on 2023/8/15
 */
public interface TokenizerService {

    PageResult<Tokenization> pageQuery(int pageNum, int pageSize);

    boolean save(List<Tokenization> list);
}
