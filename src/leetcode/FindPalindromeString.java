package leetcode;

import java.util.Arrays;

/**
 * FindPlalindromeString
 *
 * Date: 2019/10/7
 * Description: leetcode5:最长回文子串 todo 未完成
 */

public class FindPalindromeString {

    public static void main(String[] args) {
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
        int length = 0, index = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            int l = search(s, i, Math.min(i, s.length() - i - 2));
            if (length < l) {
                length = l;
                index = i;
            }
        }
        return index == 0 ? "" : s.substring(index - length, index + length);
    }

    static int search(String s, int index, int length) {
        int i;
        for (i = 0; i <= length; i++) {
            if (s.charAt(index - i) != s.charAt(index + i + 1)) {
                break;
            }
        }
        return i ;
    }
}
