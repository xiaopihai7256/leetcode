package leetcode;

/**
 * ReverseBits
 *
 * 190: 颠倒二进制
 * see: https://leetcode-cn.com/problems/reverse-bits/
 * Date: 2019/11/17
 * Description: 颠倒二进制
 */

public class ReverseBits {

    /**
     * 1ms， 运行速度击败100%， 内存5.5%
     * @param n 32位输入
     * @return 颠倒后输入
     */
    public int reverseBits(int n) {
        int result = n;
        for (int i = 0; i < 31; i++) {
            result = result << 1;
            n = n >>> 1;
            result = result | n & 1;
        }
        return result;
    }
}
