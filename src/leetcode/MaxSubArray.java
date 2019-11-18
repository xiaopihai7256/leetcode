package leetcode;

/**
 * LeetCode53
 *
 * Date: 2019/11/5
 * Description: todo
 */

public class MaxSubArray {

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



}
