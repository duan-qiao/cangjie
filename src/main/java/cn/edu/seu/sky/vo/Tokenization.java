package cn.edu.seu.sky.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xiaotian on 2023/8/15
 */
@Data
public class Tokenization implements Serializable {

    private static final long serialVersionUID = 2884939944630328043L;

    private Long id;

    private String sentence;

    private List<Token> tokens;
}
