package cn.edu.seu.sky.service;

import cn.edu.seu.sky.entity.Dict;

import java.util.List;

/**
 * @author xiaotian on 2023/8/13
 */
public interface DictService {

    void batchSave(List<String> dictList);

    void saveOne(String word);

    Dict queryOne(String word);
}
