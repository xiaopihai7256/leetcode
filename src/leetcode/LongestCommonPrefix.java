package leetcode;

/**
 * LeetCode14
 *
 * Date: 2019/11/5
 * Description: 对于给定的字符串，寻找最长公共前缀
 */

public class LongestCommonPrefix {


    public static void main(String[] args) {
        // String[] strs = new String[]{"flower","flow","flight"};
        String[] strs = new String[]{"c","c"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {

        int length = strs.length;
        if (length == 0) {
            return "";
        } else if (length == 1) {
            return strs[0];
        }
        char lineChar, otherChar;
        String line = strs[0];
        int count = 0, lineLength = line.length(), j;
        for (int i = 0; i < lineLength; i++, count++) {
            lineChar = line.charAt(i);
            for (j = 1; j < length; j++) {
                String other = strs[j];
                if (i >= other.length()) return line.substring(0, count);
                otherChar = other.charAt(i);
                if (lineChar != otherChar) return line.substring(0, count);
            }
        }
        return line.substring(0, count);
    }
}
