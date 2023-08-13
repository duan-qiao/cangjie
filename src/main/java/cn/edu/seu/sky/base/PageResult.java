package cn.edu.seu.sky.base;

import cn.edu.seu.sky.utils.BeanUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author xiaotian on 2022/6/6
 */
@Data
public final class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 结果集
     */
    private List<T> list;
    /**
     * 当前页
     */
    private long pageNum;
    /**
     * 每页的数量
     */
    private long pageSize;
    /**
     * 总页数
     */
    private long pages;
    /**
     * 总记录数
     */
    private long total;
    /**
     * 是否有上一页
     */
    private boolean hasPreviousPage;
    /**
     * 是否有下一页
     */
    private boolean hasNextPage;

    public static <S, T> PageResult<T> of(IPage<S> pageInfo, Supplier<T> supplier) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setList(BeanUtils.copyList(pageInfo.getRecords(), supplier));
        pageResult.setPageNum(pageInfo.getCurrent());
        pageResult.setPageSize(pageInfo.getSize());
        pageResult.setPages(pageInfo.getPages());
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setHasPreviousPage(pageInfo.getCurrent() > 1);
        pageResult.setHasNextPage(pageInfo.getCurrent() < pageInfo.getPages());
        return pageResult;
    }

    public static <T> PageResult<T> of(int pageNo, int pageSize, long total, List<T> data) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageNum(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setPages((int) (total / pageSize == 0 ? total / pageSize : total / pageSize + 1));
        pageResult.setTotal(total);
        pageResult.setList(data);
        pageResult.setHasPreviousPage(pageNo > 1);
        pageResult.setHasNextPage(pageNo < pageResult.getPages());
        return pageResult;
    }

    public static <T> PageResult<T> empty() {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageNum(0);
        pageResult.setPageSize(0);
        pageResult.setPages(0);
        pageResult.setTotal(0L);
        pageResult.setList(Collections.emptyList());
        pageResult.setHasPreviousPage(false);
        pageResult.setHasNextPage(false);
        return pageResult;
    }
}
