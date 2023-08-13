package cn.edu.seu.sky.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author xiaotian on 2023/8/13
 */
@Data
@TableName("t_poi")
public class Poi {

    @TableId
    private Long id;

    private String poiId;

    private String poiName;

    private String address;

    private Double lat;

    private Double lng;

    private String province;

    private String city;

    private String district;

    private Integer adcode;

    private Date createTime;

    private Date updateTime;
}
