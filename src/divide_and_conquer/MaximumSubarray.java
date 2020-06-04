package divide_and_conquer;

import java.util.Arrays;
import java.util.Random;

/**
 * date: 2020/6/3
 * description: 最大子数组问题
 *
 * @author huifei.liu@hand-chian.com
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] a = {1, -1, 2, 1, 0 ,-4,6,-7,8,-5,-4,4,3,-2, 6};
        long[] midResult = findMaxCrossSubarray(a, 0, ( a.length - 1 ) / 2, a.length - 1);
        System.out.println(Arrays.toString(midResult));

        long[] result = findMaximumSubarray(a, 0, a.length - 1);
        System.out.println(Arrays.toString(result));
        System.out.println(maxSubArray2(a));
        // 测试分组解法和O(n)解法的性能差异
        // 构造数据
        Random random =  new Random(System.currentTimeMillis());
        int[] testArr = new int[1000000];
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = random.nextInt();
        }
        System.out.println(maxSubArray2(testArr));
        long[] divideConquer = findMaximumSubarray(testArr, 0, testArr.length - 1);
        System.out.println(Arrays.toString(divideConquer));

    }


    /**
     * 跨越中点的最大子数组, 需要mid有意义，必须保证A至少存在两个元素
     * @param A 数组A
     * @param low 低位
     * @param mid 中位
     * @param high 高位
     * @return [max-left: 左最大和下标, max-right: 右最大和下标, max-left+max-right: 左右最大和]
     */
    static long[] findMaxCrossSubarray(int[] A, int low, int mid, int high) {

        // 左
        long leftSum = Long.MIN_VALUE;
        long sum = 0;
        int maxLeft = mid;
        for (int i = mid; i >= low; i--) {
            sum = sum + A[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        // 右
        long rightSum = Long.MIN_VALUE;
        sum = 0;
        int maxRight = mid + 1;
        for (int i = mid + 1; i <= high; i++) {
            sum = sum + A[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        return new long[]{maxLeft, maxRight, (long)leftSum + (long)rightSum};
    }

    static long[] findMaximumSubarray(int[] A, int low, int high) {
        if (low == high) {
            return new long[]{low, high, A[low]}; // case length == 1
        }
        int mid = (high + low) / 2;
        // left
        long[] leftResult = findMaximumSubarray(A, low, mid);
        long leftSum = leftResult[2];
        // right
        long[] rightResult = findMaximumSubarray(A, mid + 1, high);
        long rightSum = rightResult[2];
        // mid
        long[] midResult = findMaxCrossSubarray(A, low, mid, high);
        long midSum = midResult[2];

        if (leftSum >= midSum && leftSum >= rightSum) {
            return leftResult;
        } else if (rightSum >= leftSum && rightSum >= midSum) {
            return rightResult;
        } else {
            return midResult;
        }
    }

    public static long maxSubArray2(int[] nums) {

        long plus = 0, seed = nums[0];
        for (int num : nums) {
            if (plus > 0) {
                plus += num;
            } else {
                plus = num;
            }
            seed = Math.max(plus, seed);
        }
        return seed;
    }

}
