package leetcode;

import java.util.Arrays;

/**
 * date: 2020/10/8
 * description: ReverseString
 *
 * @author xiaopihai7256
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'd'};
        reverseString(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 逆反字符串
     * 要求：O(1)空间复杂度
     * @param s
     */
    public static void reverseString(char[] s) {
        if (s.length <= 1) return;
        int half = s.length / 2, max = s.length - 1;
        char temp;
        for (int i = 0; i < half; i++) {
            temp = s[i];
            s[i] = s[ max - i];
            s[max - i] = temp;
        }
    }

}
