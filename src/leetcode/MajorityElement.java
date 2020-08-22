package leetcode;

/**
 * date: 2020/6/9
 * description: leetcode: 39
 *
 * @author xiaopihai7256
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {3, 2, 3};

        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(arr));
    }

    /**
     * 摩尔投票法, 标准解
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int x = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                x = num;
            }
            count += (num == x) ? 1 : -1;
        }
        return x;

    }

    /**
     * 速度超越74%
     * 自己的解题思路：如果将数组看作一个循环链表，则最长的相同数字的子串一定是超过一半的那个众数
     * @param nums 目标数组
     * @return 超过一半的众数
     */
    public int majorityElement(int[] nums) {
        if (nums[0] == nums[nums.length - 1]) {
            return findMax2(nums);
        } else {
            return findMax(nums);
        }
    }

    public int findMax(int[] doubleNums) {
        int count = 1, result = 1, num = doubleNums[0];
        for (int i = 1; i < doubleNums.length; i++) {
            if (doubleNums[i] == doubleNums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > result) {
                result =  count;
                num = doubleNums[i];
            }
        }
        return num;
    }

    public int findMax2(int[] doubleNums) {
        int count = 1, result = 1, num = doubleNums[0];
        int i, n;
        for (i = 1; i < doubleNums.length; i++) {
            n = doubleNums[i - 1];
            if (doubleNums[i] == n) {
                count++;
            } else {
                count = 1;
            }
            if (count > result) {
                result =  count;
                num = doubleNums[i];
            }
        }
        n = doubleNums[i - 1];
        for (i = 0; i < doubleNums.length; i++) {
            if (doubleNums[i] == n) {
                count++;
            } else {
                count = 1;
            }
            if (count > result) {
                result =  count;
                num = doubleNums[i];
            }
            n = doubleNums[i];
        }
        return num;
    }







}
