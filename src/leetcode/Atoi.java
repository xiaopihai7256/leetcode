package leetcode;

/**
 * AToI
 *
 * @author huifei.liu@hand-chian.com
 * Date: 2019-07-16
 * Description: 字符串转数字
 */

public class Atoi {

    public static void main(String[] args) {

        System.out.println(myAtoi("  0000000000012345678"));
        System.out.println(myAtoi("20000000000000000000"));
        System.out.println(myAtoi(" "));
        System.out.println(myAtoi("aaaa-123123123453453453453f"));
        System.out.println(myAtoi("-9223372036854775809"));
        System.out.println(myAtoi("  +1  -4234"));
        System.out.println(myAtoi("-000000000"));
        System.out.println(myAtoi("-8888888888"));
        System.out.println(myAtoi("-9128347230"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("3.14159"));
        System.out.println(myAtoi("+"));
        System.out.println(myAtoi("-"));
        System.out.println(myAtoi("-++--"));
        System.out.println(myAtoi("  -42"));
        System.out.println(myAtoi("43"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi(".1"));
        System.out.println(myAtoi(" 00000000001"));
        System.out.println(myAtoi("-2147483647"));
        System.out.println(myAtoi("2147483647"));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("1a"));

    }

    /**
     * 执行用时 : 2ms
     */
    static final int max = Integer.MAX_VALUE/10;
    public static int myAtoi(String str) {
        System.out.print("\"" + str + "\" >>>> ");
        // 非法情况直接返回，节省时间
        if (str == null || str.isEmpty()) return 0;
        // trim一下，简化逻辑
        String trimmed = str.trim();
        if (trimmed.isEmpty()) return 0;
        // 非空第一个字符，决定正负，确认 起始遍历的index
        boolean isPositive = true;
        int s = 0, length = trimmed.length();
        char c = trimmed.charAt(0);
        if (c == '-') {
            isPositive = false;
            s = 1;
        } else if (c == '+') {
            s = 1;
        }
        int result = 0, current;
        for (int i = s; i < length; i++) {
            current = trimmed.charAt(i) - 48;
            if (current > 9 || current < 0)  break;
            if (result > max || (result == max && current > 7)) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + current;
        }
        return isPositive ? result : -result;
    }

    /**
     * 执行用时 :
     * 11 ms
     * , 在所有 Java 提交中击败了
     * 42.79%
     * 的用户
     * 内存消耗 :
     * 36.1 MB
     * , 在所有 Java 提交中击败了
     * 85.44%
     * 的用户
     * @param str
     * @return
     */
    //
    public static int myAtoi3(String str) {

        if (str == null || str.length() < 1) {
            return 0;
        }
        Boolean isPositive = null;
        boolean start = false;
        char[] number = new char[11];
        int count = 0;
        for (int i = 0; i < str.length() && count <= 10; i++) {
            char c = str.charAt(i);
            if (!start) {
                if (c == ' ') {
                    continue;
                } else {
                    start = true;
                }
            }
            if (c != '+' && c != '-' && (c < '0' || c > '9')) {
                break;
            }
            if (isPositive == null) {
                isPositive = c != '-';
            } else if (c == '+' || c == '-') {
                break;
            }
            if (count == 0 && c == '0') {
                continue;
            }
            if (c >= '0') {
                number[count] = c;
                count++;
            }
        }
        String num = new String(number).substring(0, count);
        if (isPositive == null || num.length() < 1) {
            return 0;
        }
        long result = Long.parseLong(num.substring(0, count));
        if (isPositive) {
            return result >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
        } else {
            return result >= (long)Integer.MAX_VALUE + 1 ? Integer.MIN_VALUE :  (int)(0 - result);
        }
    }


}
