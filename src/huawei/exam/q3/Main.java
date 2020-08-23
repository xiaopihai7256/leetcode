package huawei.exam.q3;

import java.util.Scanner;

/**
 * date: 2020/8/23
 * description: 字典序，非回文串搜索
 *
 * 指定一个数字N; 1-26之间， 字符串的字符只会出现 前N个字母
 * 提供一个初始字符串： 长度小于10000
 * 要求：在字符串后面的等长的字典序中，搜索第一个不包含回文串的字符串并返回，如果没有搜索到返回 NO
 *
 * 输入每次两行：
 * 第一行：N
 * 第二行：字符串
 * >> 第三行要求输出结果
 *
 * @author xiaopihai7256
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int num = Integer.parseInt(in.nextLine());
            String rawData = in.nextLine();
            System.out.println(test(num, rawData));
        }
    }

    public static String test(int num, String startDicStr) {
        char[] dicStr = startDicStr.toCharArray();
        while((dicStr = nextDicStr(num, dicStr)) != null) {
            if (isValid(dicStr)) return new String(dicStr);
        }
        return "NO";
    }

    // 当前指定数字下的下一个字典序字符串
    public static char[] nextDicStr(int num, char[] dicStr) {
        for (int i = dicStr.length - 1; i>=0; i--) {
            if (dicStr[i] < num - 1 + 'a') {
                dicStr[i] = (char)(dicStr[i] + 1);
                for (int j = i + 1; j < dicStr.length; j++) {
                    dicStr[j] = 'a';
                }
                return dicStr;
            }
        }
        return null;
    }

    // 是否不包含回文字符串
    public static boolean isValid(char[] dicStr) {
        for (int i = 0; i < dicStr.length -1; i++) {
            if (isFirstType(dicStr, i) || isSecondType(dicStr, i)) {
                return false;
            }
        }
        return true;
    }
    // 偶数对称
    public static boolean isFirstType(char[] chars, int index) {
        if(index + 1 < chars.length && index >= 0) {
            return chars[index] == chars[index + 1];
        }
        return false;
    }
    // 基数对称
    public static boolean isSecondType(char[] chars, int index) {
        if(index - 1 >= 0 && index + 1 < chars.length) {
            return chars[index - 1] == chars[index + 1];
        }
        return false;
    }



}
