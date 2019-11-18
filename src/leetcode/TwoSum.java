package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * SumNumber
 *
 * Date: 2019-06-16
 * Description: 两数之和 leetcode 1
 */

public class TwoSum  {

    public static void main(String[] args) {

        int[] nums = {3,2,4};
        Arrays.stream(twoSum(nums, 6)).forEach(System.out::println);
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return index;
    }

    public static int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> number = new HashMap<>(nums.length);
        number.put(target - nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            Integer j = number.get(target - num);
            if (j == null) {
                number.put(num, i);
            } else {
                return new int[]{j, i};
            }
        }
        return null;
    }
}
