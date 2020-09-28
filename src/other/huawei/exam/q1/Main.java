package  other.huawei.exam.q1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     * 字符串加密，查值移位，值按照指定规律生成
     * 数一个只包含英语字符的字符串，要求按照指定的值移位加密。
     * a[3] -> a[0] + a[1] + a[2], a[0] = 1, a[1]=2, a[2]=4
     * 如果 i>3, a[i] = a[i-1] + a[i-2] + a[i-3]
     *
     * 对于原始字符串，第i个字符移动a[i]位，比如 输入: xy -> yb(注意，这里提示了超过26需要从继续开始）
     * x 移动1位，因为a[0] = 1: x->y, y移动两位, 因为 a[1]=2, y->z->a
     *
     * 输入：
     * 第一行：N, 表示接下来要输入N个待移位的字符串
     * >> 输入N行字符串
     * >> 输入结果
     * (这里有个坑，结果需要计算完成后一起输出，否则题目判定会失败）
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int num = Integer.parseInt(in.nextLine());
            String[] strArray = new String[num];
            for (int i = 0; i < num; i++) {
                strArray[i] = encrypt(in.nextLine());
            }
            for (String str : strArray) {
                System.out.println(str);
            }
        }

    }

    public static final List<Integer> dic = new ArrayList<>();
    static {
        dic.add(1);
        dic.add(2);
        dic.add(4);
    }

    public static int getMoveCount(int i) {
        if (dic.size() - 1 < i) {
            for (int index = dic.size(); index <= i; index++) {
                int reuslt = dic.get(index-1) + dic.get(index-2) + dic.get(index-3);
                dic.add(reuslt % 26);
            }
        }
        return dic.get(i);
    }


    public static String encrypt(String str) {
        if (str == null) return str;
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = (char)(((str.charAt(i) - 'a') + getMoveCount(i)) % 26 + 'a');
        }
        return new String(result);
    }
}