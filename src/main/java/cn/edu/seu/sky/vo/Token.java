package cn.edu.seu.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xiaotian on 2023/8/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token implements Serializable {

    private static final long serialVersionUID = 1101651408481077802L;

    private String word;

    private Integer category;
}
