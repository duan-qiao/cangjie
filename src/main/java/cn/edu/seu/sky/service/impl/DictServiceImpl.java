package cn.edu.seu.sky.service.impl;

import cn.edu.seu.sky.mapper.DictMapper;
import cn.edu.seu.sky.entity.Dict;
import cn.edu.seu.sky.service.DictService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaotian on 2023/8/13
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    @Override
    public void batchSave(List<String> words) {
        words.forEach(this::saveOne);
    }

    @Override
    public void saveOne(String word) {
        LambdaUpdateWrapper<Dict> wrapper = Wrappers.<Dict>lambdaUpdate()
                .setSql("frequency = frequency + 1")
                .eq(Dict::getWord, word);
        if (!this.update(wrapper)) {
            this.save(new Dict(word));
        }
    }

    @Override
    public Dict queryOne(String word) {
        return this.getOne(Wrappers.<Dict>lambdaQuery().eq(Dict::getWord, word));
    }
}
