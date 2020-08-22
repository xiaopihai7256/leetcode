package sort;

import java.util.Arrays;

/**
 * date: 2020/6/2
 * description: 冒泡排序
 *
 * @author xiaopihai7256
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {233,52,7,3,5,7,8,3,34,57,8};
        sort(arr);
        System.out.println(Arrays.toString(arr ));
    }


/**
 * 冒泡排序
 *
 * 外层迭代: 保证迭代次数 n - 1 次迭代，最后剩下的，就是最大的那个元素，在顶部，所以不需要迭代
 * 内层迭代: 每次迭代，会把当前 i+1 => n 的最小的元素移动到 i 位置, 比如第一次迭代把整个数组里最小的元素移动到了0位置
 *
 * @param arr 待排数组,原址排序
 */
public static void sort(int[] arr) {

    int temp;
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = arr.length - 1; j > i; j--) {
            if (arr[j] < arr[j - 1]) {
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }
}
}
