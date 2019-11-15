package sort;

import java.util.Arrays;

/**
 * QuickSort
 *
 * @author huifei.liu@hand-chian.com
 * Date: 2019/11/13
 * Description: 快排
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {9,16,3,2,4,8,5,14,12};
        quickSort(arr,0, 8);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q -1);
            quickSort(A, q + 1, r);
        }
    }

    static int partition(int[] A, int p, int r) {

        int x = A[r];
        int i = p - 1;
        int temp;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i += 1;
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                System.out.println(Arrays.toString(A));
            }
        }
        temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;
        System.out.println(Arrays.toString(A));
        return i + 1;
    }
}
