package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * FindPlalindromeString
 *
 * @author huifei.liu@hand-chian.com
 * Date: 2019/10/7
 * Description: leetcode5:最长回文子串
 */

public class FindPalindromeString {

    public static void main(String[] args) {
        char[] a = new char[20];
        System.out.println(Arrays.toString(a));
        String[] demo = {
                "ccccc",
                "abcdabcd",
                "abcdaaaaaaa"
        };
        int i = 0;
        for (String s : demo) {
            System.out.println(i + ":" + s);
            String result = longestPalindrome(s);
            System.out.println("length: " + result.length() + ",result is:[" + result + "]");
        }
    }

    /**
     * abcdabaa
     * leetCode 5
     * @param s
     * @return
     */
    static String longestPalindrome(String s) {

        if ("".equals(s)) {
            return s;
        }

        return null;
    }
}
