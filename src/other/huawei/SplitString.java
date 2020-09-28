package other.huawei;

import java.util.Scanner;

/**
 * date: 2020/8/23
 * description: SplitString
 *
 * @author xiaopihai7256
 */
public class SplitString {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            splitString(str);
        }
    }

    public static final String zero = "00000000";

    /**
     * 字符串切割，输入一定长度的字符串，按照每行8个字符的长度输出，不够补0
     * @param str
     */
    public static void splitString(String str) {
        int count = str.length() / 8;
        int left = str.length() % 8;
        int i;
        for (i = 0; i < count; i++) {
            System.out.println(str.substring(i *  8, i*8 + 8));
        }
        if (left != 0)  {
            System.out.print(str.substring(i*8, i*8+left));
            System.out.println(zero.substring(0,8 - left));
        }
    }

}
