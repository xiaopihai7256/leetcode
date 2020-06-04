package leetcode;

/**
 *
 * 最大子数组问题
 * Date: 2019/11/5
 * Description: LeetCode53/121/122
 */

public class MaxSubArray {

    /**
     * leetCode 53
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int plus = 0, seed = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (plus > 0) {
                plus += num;
            } else {
                plus = num;
            }
            seed = Math.max(plus, seed);
        }
        return seed;
    }

    /**
     * leetcode 121: 买股票的最佳时机
     * @param prices
     * @return
     */
    public static int maxSubArray2(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }
        int plus = 0, seed = 0;
        for (int i = 1; i < prices.length; i++) {
            int num = prices[i] - prices[i - 1];
            if (plus > 0) {
                plus += num;
            } else {
                plus = num;
            }
            seed = Math.max(plus, seed);
        }
        return seed;
    }

    /**
     * leetcode 122: 买股票的最佳时机II
     * @param prices
     * @return
     */
    public static int maxSubArray3(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }
        int plus = 0;
        for (int i = 1; i < prices.length; i++) {
            int num = prices[i] - prices[i - 1];
            if (num > 0) {
                plus = plus + num;
            }
        }
        return plus;
    }


}
