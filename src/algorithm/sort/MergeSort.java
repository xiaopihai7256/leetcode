package algorithm.sort;

/**
 * MergeSort
 *
 * Date: 2019/11/13
 * Description: 归并排序
 */

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {9,16,3,2,4,8,5,14,12};
        mergeSort(arr,0, arr.length - 1);
    }

    public static void  mergeSort(int[] arr, int p, int r) {
        if (p < r) {
            // 计算q，分组
            int q = (p + r) / 2;
            // 排序左边
            mergeSort(arr, p, q);
            // 排序右边
            mergeSort(arr, q + 1, r);
            // 合并左右结果
            merge2(arr, p, q, r);
        }
    }

    /**
     * arr 原始数组
     * @param arr 原始数组
     * @param p 当前Left分组的起始点下标
     * @param q 当前中间节点下标
     * @param r 当前Right分组的结束点下标
     */
    public static void merge(int[] arr, int p, int q, int r) {
        // 计算两个分组的长度
        int n1 = q - p + 1;
        int n2 = r - q;
        // 复制原数组对应端的数据到两个新的分组
        int[] lArr = new int[n1 + 1];
        int[] rArr = new int[n2 + 1];
        System.arraycopy(arr, p, lArr,0, n1);
        // max 代表书中的无限大
        lArr[n1] = Integer.MAX_VALUE;
        System.arraycopy(arr, q + 1, rArr,0, n2);
        rArr[n2] = Integer.MAX_VALUE;
        // 开始排序
        int i = 0, j = 0;
        // 遍历当前排序区间
        for (int k = p; k < r + 1; k++) {
            // 左侧拿牌
            if (lArr[i] <= rArr[j]) {
                arr[k] = lArr[i];
                i++;
            } else { // 右侧拿牌
                arr[k] = rArr[j];
                j++;
            }
        }
        // 打印每一次merge的结果
        // System.out.println(Arrays.toString(arr));
    }

    /**
     * arr 原始数组, 不使用哨兵牌，判断条件改为i,j两个索引必须同时小于各自数组的长度
     * @param arr 原始数组
     * @param p 当前Left分组的起始点下标
     * @param q 当前中间节点下标
     * @param r 当前Right分组的结束点下标
     */
    public static void merge2(int[] arr, int p, int q, int r) {
        // 计算两个分组的长度
        int n1 = q - p + 1;
        int n2 = r - q;
        // 复制原数组对应端的数据到两个新的分组
        int[] lArr = new int[n1];
        int[] rArr = new int[n2];
        System.arraycopy(arr, p, lArr, 0, n1);
        System.arraycopy(arr, q + 1, rArr, 0, n2);
        // 开始排序
        int i = 0, j = 0, k;
        // 遍历当前排序区间
        for (k = p; i < n1 && j < n2; k++) {
            // 左侧拿牌
            if (lArr[i] <= rArr[j]) {
                arr[k] = lArr[i];
                i++;
            } else { // 右侧拿牌
                arr[k] = rArr[j];
                j++;
            }
        }
        // 拿未拿完的堆的牌到排序堆顶
        if (i == n1) {
            System.arraycopy(rArr, j,arr, k, n2  - j);
        } else {
            System.arraycopy(lArr, i,arr, k, n1  - i);
        }
        // 打印每一次merge的结果
        // System.out.println(Arrays.toString(arr));
    }

}
