package cn.edu.seu.sky.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xiaotian on 2023/8/19
 */
@Getter
@AllArgsConstructor
public enum CategoryEnum {
    /**
     * 词性分类
     */
    UNKNOWN(0, "未知"),
    /**
     * 省
     */
    LOC(1, "地名"),
    /**
     * 人名
     */
    PER(2, "人名"),
    /**
     * 机构名
     */
    ORG(3, "机构名"),
    /**
     * 类型词
     */
    TYPE(4, "类型词"),
    /**
     * 名称词
     */
    NAME(5, "名称词"),
    ;

    private final int value;

    private final String desc;
}
