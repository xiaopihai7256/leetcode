package other.didi;

/**
 * date: 2020/9/29
 * description: FindMaxSubStr
 * 滴滴面试原题，求两个字符串的最长公共字串
 * @author xiaopihai7256
 */
public class FindMaxSubStr {

    public static void main(String[] args) {
        String str1 = "bdcaba";
        String str2 = "abcbdab";
        // 求最长自序
        maxSubSeq(str1, str2);
        // 求最长字串
        maxSubStr(str1, str2);
    }


    /**
     * 求最长公共字串
     * fixme: 空间复杂度非最优，可以只申请两行的table就可以计算
     * str: a, b , c ,d
     * str2:a, y, b, w, c, q
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 最长公共字串，未搜索到返回空字符串
     */
    public static String maxSubStr(String str1, String str2) {
        int[][] map = new int[str1.length() + 1][str2.length() + 1];
        // 填充矩阵
        int maxLength = 0, index = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    map[i][j] = map[i-1][j-1] + 1;
                    if (map[i][j] > maxLength) {
                        maxLength = map[i][j];
                        index = i - 1;
                    }
                }
            }
        }
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[0].length; j++) {
//                System.out.print("[" + map[i][j] + "]");
//            }
//            System.out.println();
//        }
        return str1.substring(index + 1 - maxLength, index + 1);
    }

    /**
     * 最长公共子序
     */
    public static String maxSubSeq(String str1, String str2) {
        // 建立矩阵
        int[][] map = lcs(str1.toCharArray(), str2.toCharArray());
        StringBuilder builder = new StringBuilder();
        // 搜索结果
        searchMap(map, str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length(), builder);
        // 因为结果是倒序搜索，所以逆反后返回
        return builder.reverse().toString();
    }

    /**
     * 建立lcs矩阵
     * str: a, b , c ,d
     * str2:a, y, b, w, c, q
     */
    public static int[][] lcs(char[] str1, char[] str2) {
        int[][] map = new int[str1.length + 1][str2.length + 1];
        // 填充矩阵
        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if (str1[i-1] == str2[j-1]) {
                    map[i][j] = map[i-1][j-1] + 1;
                } else if (map[i-1][j] >= map[i][j-1]) {
                    map[i][j] = map[i-1][j];
                } else {
                    map[i][j] = map[i][j-1];
                }
            }
        }
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[0].length; j++) {
//                System.out.print("[" + map[i][j] + "]");
//            }
//            System.out.println();
//        }
        return map;
    }

    public static void searchMap(int[][] map, char[] str1, char[] str2, int i, int j, StringBuilder builder) {
        if (i == 0 || j == 0) {
            return;
        }
        if (str1[i-1] == str2[j-1]) {
            builder.append(str1[i-1]);
            searchMap(map, str1, str2,i - 1, j - 1, builder);
        } else if (map[i-1][j] >= map[i][j-1]) {
            searchMap(map, str1, str2, i - 1, j, builder);
        } else  {
            searchMap(map, str1, str2, i , j - 1, builder);
        }
    }

}
