package algorithm.sort;

import java.util.Arrays;

/**
 * date: 2020/9/30
 * description: CountingSort
 * 计数排序，算法导论8.2, 理论基础：决策模型
 * @author xiaopihai7256
 */
public class CountingSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countingSort(new int[]{1,3,6,2,9,7,4,5,10,2,5,3,6,4,6,7,8,4,5,8,9}, 10)));
    }

    /**
     * 计数排序有一个明显的缺陷就是，如果数组中存在一个很大的数字，
     * 就是导致申请对应数量的内存空间，也就是数字差距越大，空间利用率越低
     * @param arr arr数组
     * @param k arr数组中最大的元素
     * @return 排序结果
     */
    static int[] countingSort(int[] arr, int k) {
        int[] result = new int[arr.length];
        int[] c = new int[k + 1];
        // counting
        for (int i = 0; i < arr.length; i++) {
            c[arr[i]]++;
        }
        for (int i = 1;i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }
        // fill
        for (int i = 0; i < arr.length; i++) {
            // c[arr[i]]表示小于等于arr[i]的数字的数量，如果是3，则表示当前arr[i]应该填充在
            // 结果数组的第三个index的位置，也就是 c[arr[i]] - 1的索引的位置
            result[c[arr[i]] - 1] = arr[i];
            c[arr[i]]--;
        }
        return result;
    }


}
