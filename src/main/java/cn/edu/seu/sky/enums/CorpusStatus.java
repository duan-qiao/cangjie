package cn.edu.seu.sky.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xiaotian on 2023/8/19
 */
@Getter
@AllArgsConstructor
public enum CorpusStatus {
    /**
     * 文本处理状态
     */
    UN_PROCESSED(0, "未处理"),
    PROCESSED(1, "已处理"),
    ;

    private final int value;

    private final String desc;
}
