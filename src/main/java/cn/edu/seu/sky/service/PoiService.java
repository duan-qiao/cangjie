package cn.edu.seu.sky.service;

import cn.edu.seu.sky.base.PageResult;
import cn.edu.seu.sky.entity.Poi;

/**
 * @author xiaotian on 2023/8/13
 */
public interface PoiService {

    PageResult<Poi> pageQuery(int pageNo, int pageSize);

    Poi queryByPoiId(String poiId);
}
