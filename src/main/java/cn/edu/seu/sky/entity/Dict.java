package cn.edu.seu.sky.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xiaotian on 2023/8/13
 */
@Data
@TableName("t_dict")
@NoArgsConstructor
public class Dict {

    @TableId
    private Long id;

    private String word;

    private Integer frequency;

    private Integer category;

    @TableLogic
    private Integer deleted;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    public Dict(String word) {
        this.word = word;
    }
}
