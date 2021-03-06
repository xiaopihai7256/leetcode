package leetcode;

/**
 * LeetCode67
 *
 * Date: 2019/11/12
 * Description: leetcode 67
 */

public class AddBinary {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(48));
        System.out.println(addBinary3("11","10"));
        System.out.println(addBinary3("110010101001","100101000100101010"));
        System.out.println(addBinary3("01001010101001010101001010100010100011010011001010010101","0"));
        System.out.println(addBinary3("0100101","001010010001001001010101001110111110"));
    }


    static String addBinary(String a, String b) {
        int len1 = a.length(), len2 = b.length();
        if (len1 > len2) {
            b = repeat('0', len1 - len2) + b;
        } else if (len2 > len1) {
            a = repeat('0', len2 - len1) + a;
        }
        char[] result = a.toCharArray();
        boolean adder = false;
        for (int i = result.length - 1; i >= 0; i--) {
            char a1 = result[i];
            char b1 = b.charAt(i);
            if (a1 == '1' && b1 == '1') {
                result[i] = adder ? '1' : '0';
                adder = true;
            } else if (a1 == '0' && b1 == '0') {
                result[i] = adder ? '1' : '0';
                adder = false;
            } else {
                result[i] = adder ? '0' : '1';
                adder = adder && result[i] == '0';
            }
        }
        String s = new String(result);
        return adder ? "1" + s : s;
    }

    static String addBinary2(String a, String b) {
        int len1 = a.length(), len2 = b.length();
        if (len1 > len2) {
            b = repeat('0', len1 - len2) + b;
        } else if (len2 > len1) {
            a = repeat('0', len2 - len1) + a;
        }
        char[] result = a.toCharArray();
        int adder = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            int sumResult = result[i] + b.charAt(i) + adder - 96;
            result[i] = (char)((sumResult & 1) + 48);
            adder = sumResult >>> 1;
        }
        String s = new String(result);
        return adder == 1 ? "1" + s : s;
    }

    static String repeat(char c, int length) {
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = c;
        }
        return new String(chars);

    }

    static String addBinary3(String a, String b) {
        String max;
        char[] result;
        if (a.length() >= b.length()) {
            max = a;
            result = repeat2(b, a.length());
        } else {
            max = b;
            result = repeat2(a, b.length());
        }
        int adder = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            int sumResult = result[i] + max.charAt(i) + adder - 96;
            result[i] = (char)((sumResult & 1) | 48);
            adder = sumResult >>> 1;
        }
        String s = new String(result);
        return adder == 1 ? "1" + s : s;
    }

    static char[] repeat2(String b, int length) {
        char[] chars = new char[length];
        int i;
        for (i = 0; i < length - b.length(); i++) {
            chars[i] = '0';
        }
        for (int j = 0; j < b.length(); j++) {
            chars[i + j] = b.charAt(j);
        }
        return chars;

    }

}
