package sort;

import java.util.Random;


/**
 * @author huifei.liu@hand-chian.com
 */
public class MergeWithInsertSort {


    public static void main(String[] args) {
        // 构造数据
        Random random =  new Random(System.currentTimeMillis());
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        // 零时数组
        int[] arr2 = new int[arr.length];
        // 步长为 5，测试最优解 k 值
        for (int i = 1; i <= 500; i += 5) {
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            long start = System.currentTimeMillis();
            mergeWithInsert(arr2, 0, arr2.length - 1, i);
            long end  = System.currentTimeMillis();
            System.out.println("k:["  + i + "] -> " + (end - start));

        }
    }


    /**
     *
     * @param arr 数组
     * @param p 起始节点下标
     * @param r 结束节点下标
     * @param k 当 r+1-q <= k 时，不再分解问题，直接使用insert解决问题
     */
    public static void mergeWithInsert(int[] arr, int p, int r, int k) {
        if (p < r) {
            // 步长小于k, 则直接采用插入排序, 制造粗叶子节点
            if ((r + 1 - p) <= k) {
                insertionSort(arr, p, r);
            } else {
                // 计算q，分组
                int q = (p + r) / 2;
                // 排序左边
                mergeWithInsert(arr, p, q, k);
                // 排序右边
                mergeWithInsert(arr, q + 1, r,  k);
                // 合并左右结果
                merge(arr, p, q, r);
            }
        }
    }

    /**
     * arr 原始数组, 不使用哨兵牌，判断条件改为i,j两个索引必须同时小于各自数组的长度
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


    private static void insertionSort(int[] arr, int p, int r) {
        int i;
        for (int j = p + 1; j <= r; j++) {
            i = j - 1;
            int key = arr[j];
            while (i >= p && arr[i] > key) {
                arr[i + 1] = arr[i];
                i = i - 1;
            }
            arr[i + 1] = key;
        }
    }

}
