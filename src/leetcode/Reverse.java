package leetcode;

/**
 * 反转数字-7：https://leetcode-cn.com/problems/reverse-integer/submissions/
 *
 * Date: 2019/11/4
 * Description: 反转数字
 */

class Reverse {

    static char[] number = "2147483647".toCharArray();
    static char[] n = new char[10];

    public static void main(String[] args) {
        System.out.println(reverse(-1234));
    }

    /**
     * 思路：转成字符数组，逆反之后，再转回数字
     * 执行用时 : 2 ms , 在所有 java 提交中击败了 73.04% 的用户, 内存消耗击败80%的用户
     */
    public static int reverse(int x) {
        // 转string
        String str = Integer.toString(x);
        int length = str.length();
        // 简单情况直接返回
        if (length == 1) {
            return x;
        }
        // 判断正负数，设定遍历起点位置
        int i = x < 0 ? 1 : 0;
        // 反转字符数组
        for (int y = 0, l = length - i ; y < l; y++) {
            n[y] = str.charAt(length - y - 1);
        }
        // 判断是否会溢出32位存储
        if (length - i == 10) {
            for (int q = 0; q < 10; q++) {
                if (n[q] < number[q]) {
                    break;
                } else if (n[q] > number[q]) {
                    return 0;
                }
            }
        }
        // 结果转换并返回
        int result = n[0] - 48;
        for (int p = 1; p < length - i; p++) {
            result = result * 10 + (n[p] - 48);
        }
        return i == 0 ? result : -result;
    }
}
