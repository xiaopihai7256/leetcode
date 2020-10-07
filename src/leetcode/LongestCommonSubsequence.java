package leetcode;

/**
 * date: 2020/9/29
 * description: LongestCommonSubsequence
 * leetcode: https://leetcode-cn.com/problems/longest-common-subsequence/
 * > 1143: 最长公共子序
 * 算法详解可阅读算法导论，第15章第三节
 * @author xiaopihai7256
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("1020304", "234"));
    }

    /**
     * 【寻找最长公共子序列的长度】
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
     *
     * 一个字符串的【子序列】是指这样一个新的字符串：它是由原字符串在不改变字符的
     * 相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
     * 若这两个字符串没有公共子序列，则返回 0。
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray(), str2 = text2.toCharArray();
        if (str1.length == 0 || str2.length == 0) return 0;
        int[][] map = new int[2][str2.length + 1];
        int current = 0, before;
        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <=str2.length; j++) {
                // current 就是当前需要计算的行
                current = i & 1;
                // current ^ 1 就是另外一行，也就是上一行
                before = current ^ 1;
                if (str1[i -1] == str2[j-1]) {
                    map[current][j] = map[before][j - 1] + 1;
                } else {
                    map[current][j] = Math.max(map[before][j], map[current][j - 1]);
                }
            }
        }
        return map[current][str2.length];
    }

}
