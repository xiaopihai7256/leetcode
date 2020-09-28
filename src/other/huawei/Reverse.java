package other.huawei;

import java.util.Scanner;

/**
 * date: 2020/8/23
 * description: Reverse
 *
 * @author xiaopihai7256
 */
public class Reverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            String result = reverse2(str);
            System.out.println(result);
        }
    }

    public String reverse(String sentence) {
        return reverse2(sentence);
    }

    /**
     * 反转句子, 以单词为单位反转句子： i hate you -> you hate i
     *
     * @param sentence 原句子
     * @return 反转后的句子
     */
    public static String reverse2(String sentence) {
        // 用i从后向前搜索空格，j保存上一次空格之前的索引位置
        // 每次i找到空格之后，复制i~j位置的字符到builder中
        // 循环结束后，由于i不满足条件会退出，所以再重复复制一次
        StringBuilder builder = new StringBuilder(sentence.length());
        int j = sentence.length() - 1;
        int i, index;
        for (i = j; i  >=0; i--)  {
            if (sentence.charAt(i) == ' ') {
                for (index = i+1; index <=j;index++) {
                    builder.append(sentence.charAt(index));
                }
                builder.append(' ');
                j = i - 1;
            }
        }
        for (index = i+1; index <=j;index++) {
            builder.append(sentence.charAt(index));
        }
        return builder.toString();
    }
}
