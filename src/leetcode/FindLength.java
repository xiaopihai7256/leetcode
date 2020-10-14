package leetcode;

/**
 * date: 2020/10/8
 * description: leetCode: 最长公共子数组
 * url: https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * 思路： 最长公共子序列变种
 * @author xiaopihai7256
 */
public class FindLength {

    public static void main(String[] args) {
        //[1,0,0,0,1,0,0,1,0,0]
        //[0,1,1,1,0,1,1,1,0,0]
        int[] a = {1,0,0,0,1,0,0,1,0,0};
        int[] b = {0,1,1,1,0,1,1,1,0,0};
        System.out.println(findLengthImpl2(a, b));
    }

    public static int findLengthImpl(int[] A, int[] B) {
        int[][] bitmap = new int[2][B.length + 1];
        int maxLength = 0, current;
        for (int i = 1; i <= A.length; i++) {
            current = i & 0x1;
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    bitmap[current][j] = bitmap[current^0x1][j-1] + 1;
                    if (maxLength < bitmap[current][j]) {
                        maxLength = bitmap[current][j];
                    }
                } else {
                    // 否则将上次计算的结果清0，否则会污染下一次迭代计算
                    bitmap[current][j] = 0;
                }
            }
        }
        return maxLength;
    }

    // 优化空间复杂度，让长度大的一方用动态数组
    public static int findLengthImpl2(int[] A, int[] B) {
        int[] max, min;
        if (A.length >= B.length) {
            max = A;
            min = B;
        } else {
            max = B;
            min = A;
        }
        int[][] bitmap = new int[2][min.length + 1];
        int maxLength = 0, current;
        for (int i = 1; i <= max.length; i++) {
            current = i & 0x1;
            for (int j = 1; j <= min.length; j++) {
                if (max[i - 1] == min[j - 1]) {
                    bitmap[current][j] = bitmap[current^0x1][j-1] + 1;
                    if (maxLength < bitmap[current][j]) {
                        maxLength = bitmap[current][j];
                    }
                } else {
                    // 将上次计算的结果清0，否则会污染下一次迭代计算
                    bitmap[current][j] = 0;
                }
            }
        }
        return maxLength;
    }


    public int findLength(int[] A, int[] B) {
        return findLengthImpl(A, B);
    }

}
