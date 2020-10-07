package leetcode;

/**
 * date: 2020/10/7
 * description: SingleNumber
 * 137: https://leetcode-cn.com/problems/single-number-ii/
 * @author xiaopihai7256
 */
public class SingleNumber2 {

    public static void main(String[] args) {
        System.out.println(16 * ((long)Integer.MAX_VALUE));
        int[] arr = {43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43};
        System.out.println(singleNumber2(arr));
    }

    /**
     * 利用掩码处理, 使用两个掩码主要是为了区分 一次和三次
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        int once = 0, twice = 0;
        for (int num : nums) {
            once = ~twice & (once ^ num);
            twice = ~once & (twice ^ num);
        }
        return once;
    }

    /**
     * bitmap解法
     * fixme: 缺陷是最大和最小数字差距过大时，会十分浪费空间，比如数组里出现 Integer.MIN 和 Integer.MAX
     * @param nums 输入
     * @return 输出
     */
    public int singleNumber(int[] nums) {

        if (nums.length == 1) return nums[0];
        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > maxNumber) maxNumber = num;
            else if (num < minNumber) minNumber = num;
        }
        int[] bitmap = toBitMap(nums, minNumber, maxNumber);
        // search
        int count = minNumber;
        for (int num : bitmap) {
            for (int i = 0; i < 16; i++) {
                if ((num >>> (i*2) & 0x3) == 1) return count;
                count++;
            }
        }
        return -1;
    }

    int[] toBitMap(int[] nums, long min, long max) {
        int mapLength = (int)((max + 1 - min) * 2 / 8);
        int [] bitmap = new int[mapLength == 0 ? 1 : mapLength];
        // fill
        for (int num : nums) {
            writeOriginalVal(bitmap, num - min);
        }
        return bitmap;
    }
    // 00 / 01 / 10 / 11
    void writeOriginalVal(int[] bitmap, long num) {
        int index = getIndex(num);
        bitmap[index] = (bitmap[index]) + (1 << getPosition(num));
    }
    // num / 15
    int getIndex(long num) {
        return (int)(num / 15);
    }
    // (num % 15) * 2
    int getPosition(long num) {
        return (int)((num & 0xff) * 2);
    }

}
