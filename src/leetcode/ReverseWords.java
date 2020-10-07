package leetcode;

import java.util.Arrays;

/**
 * date: 2020/10/7
 * description: ReverseWords
 *
 * @author xiaopihai7256
 */
public class ReverseWords {

    /**
     * 151: https://leetcode-cn.com/problems/reverse-words-in-a-string/submissions/
     * 用i从后向前搜索空格，j保存上一次空格之前的索引位置,
     * 每次i找到空格之后，复制i~j位置的字符到builder中,
     * 循环结束后，由于i不满足条件会退出，所以再重复复制一次
     * @param s input
     * @return revers words string
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder(chars.length);
        int j = chars.length - 1;
        int i, index;
        for (i = j; i > -1; i--)  {
            if (chars[i] == ' ') {
                if (i < j) {
                    for (index = i + 1 ; index <= j; index++) {
                        builder.append(chars[index]);
                    }
                    builder.append(' ');
                    j = i;
                }
                j--;
            }
        }
        if (i < j) {
            for (index = i + 1; index <= j; index++) {
                builder.append(chars[index]);
            }
        } else {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }

}
