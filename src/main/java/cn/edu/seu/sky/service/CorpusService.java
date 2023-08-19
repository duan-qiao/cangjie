package cn.edu.seu.sky.service;

import cn.edu.seu.sky.base.PageResult;
import cn.edu.seu.sky.entity.Corpus;

import java.util.List;

/**
 * @author xiaotian on 2023/8/13
 */
public interface CorpusService {
    /**
     * 分页查询
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return 语料库
     */
    PageResult<Corpus> pageQuery(int pageNum, int pageSize);

    /**
     * 批量更新状态为已处理
     * @param ids 语料库id
     */
    void updateProcessedByIds(List<Long> ids);
}
