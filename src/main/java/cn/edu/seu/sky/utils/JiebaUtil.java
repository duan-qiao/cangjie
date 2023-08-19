package cn.edu.seu.sky.utils;

import cn.edu.seu.sky.enums.CategoryEnum;
import cn.edu.seu.sky.vo.Token;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author xiaotian on 2023/8/15
 */
public final class JiebaUtil {

    private static final String REG_EX = "[`~!@#$%^&*()+=|{}':;,\\[\\].<>/?！￥…（）—【】‘；：”“’。，、？]";

    public static String filtration(String str) {
        return Pattern.compile(REG_EX).matcher(str).replaceAll("").trim();
    }

    public static List<String> process(String sentence) {
        JiebaSegmenter jiebaSegmenter = new JiebaSegmenter();
        List<SegToken> tokens = jiebaSegmenter.process(filtration(sentence), JiebaSegmenter.SegMode.SEARCH);
        return tokens.stream().map(x -> x.word).collect(Collectors.toList());
    }

    public static List<Token> handle(String sentence) {
        JiebaSegmenter jiebaSegmenter = new JiebaSegmenter();
        List<SegToken> tokens = jiebaSegmenter.process(filtration(sentence), JiebaSegmenter.SegMode.SEARCH);
        return tokens.stream().map(x -> new Token(x.word, CategoryEnum.UNKNOWN.getValue())).collect(Collectors.toList());
    }
}
