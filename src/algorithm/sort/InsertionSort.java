package algorithm.sort;

import java.util.Arrays;

/**
 * InsertSort
 *
 * Date: 2019/11/13
 * Description: 插入排序
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {9,16,3,2,4,8,5,14,12};
        // insertionSort(arr);
        insertionSortDownTo(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        int i;
        for (int j = 1; j < arr.length; j++) {
            i = j - 1;
            int key = arr[j];
            // 当i大于当前key元素时一直向前继续比较
            while (i >= 0 && arr[i] > key) {
                // 满足while条件，说明 i 对应的元素一定大于 i + 1 对应的元素和key
                // 所以 i 对应的元素向后移动一位
                arr[i + 1] = arr[i];
                // i 再向前移动
                i = i - 1;
            }
            // 循环结束后，i + 1 指向的位置肯定为空缺的，此时key 满足 key > A[i] and key <= A[i + 2]
            // 所以将key置于i + 1的位置
            arr[i + 1] = key;
            // 每次循环结束都能保证key左侧的元素有序
            // System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 从后往前排
     * @param arr
     */
    private static void insertionSortDownTo(int[] arr) {
        int i;
        for (int j = arr.length - 2; j >= 0; j--) {
            int key = arr[j];
            i = j + 1;
            while (i < arr.length && arr[i] < key) {
                arr[i - 1] = arr[i];
                i++;
            }
            arr[i - 1] = key;
        }
    }


    private static int findV(int[] a, int v) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == v) {
                return i;
            }
        }
        return -1;
    }
}
