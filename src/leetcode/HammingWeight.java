package leetcode;

/**
 * date: 2020/6/9
 * description: leetcode: 191
 *
 * @author huifei.liu@hand-chian.com
 */
public class HammingWeight {


    public int hammingWeight(int n) {

        int result = 0;
        while(n != 0) {
            result += n & 1;
            n >>>= 1;
        }
        int a = 0;
        return result;
    }

    /**
     * 此题最快的解法应该是jdk源码中的Integer.bitCount()的实现
     * 关于bigCount的解析：https://juejin.im/post/5c3969b76fb9a049a5712060
     */
    public int bitCount(int i) {
        return Integer.bitCount(i);
    }
}
