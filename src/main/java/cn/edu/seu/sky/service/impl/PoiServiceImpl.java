package cn.edu.seu.sky.service.impl;

import cn.edu.seu.sky.base.PageResult;
import cn.edu.seu.sky.mapper.PoiMapper;
import cn.edu.seu.sky.entity.Poi;
import cn.edu.seu.sky.service.PoiService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author xiaotian on 2023/8/13
 */
@Service
public class PoiServiceImpl extends ServiceImpl<PoiMapper, Poi> implements PoiService {

    @Override
    public PageResult<Poi> pageQuery(int pageNo, int pageSize) {
        IPage<Poi> page = this.page(Page.of(pageNo, pageSize));
        return PageResult.of(page, Poi::new);
    }

    @Override
    public Poi queryByPoiId(String poiId) {
        return this.getOne(Wrappers.<Poi>lambdaQuery().eq(Poi::getPoiId, poiId));
    }
}
