package huawei;

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
