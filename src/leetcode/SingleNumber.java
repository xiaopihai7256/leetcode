package leetcode;

/**
 * date: 2020/10/7
 * description: SingleNumber
 * 136: https://leetcode-cn.com/problems/single-number/
 * @author xiaopihai7256
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {1, 1 , 2 ,2}));
    }

    /**
     * 使用掩码，出现两次的数字映射到二进制时，相同位经过两次异或得0，
     * 推广到一般情况，除了出现了一次的数字外，其它位所有的统计结果都是偶数，最终异或得0，
     * 所以就会剩下只有一次的情况，刚好就是只出现一次的数字本身
     * 比较抽象的地方在于，此规律符合交换律
     * @param nums 输入数字集合
     * @return 只出现一次的数字的结果
     */
    public static int singleNumber(int[] nums) {
        int once = 0;
        for (int num : nums) {
            once = once ^ num;
        }
        return once;
    }

}
