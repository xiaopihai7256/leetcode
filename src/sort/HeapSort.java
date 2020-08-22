package sort;

import java.util.Arrays;

/**
 * date: 2020/8/22
 * description: 堆排序
 * 解释：
 *  heapSize: 本实现中的heapSize指定的是堆有效存储的最后位的值的数组下标
 *            如果 N个元素全部有效的话，则heapSize位 N-1（从0开始计算）
 * parent, left, right: 输入为i，先+1, 模拟下标从1开始计算，符合堆下标
 *          计算公式，计算完成后再-1，恢复实际下标
 * 下面不做特殊说明的，默认全都认为下标从0开始, 以免在下标使用时出现误用
 * @author xiaopihai7256
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        HeapSort sort = new HeapSort();
        sort.buildMaxHeap(A);
        System.out.println(Arrays.toString(A));
        sort.buildMinHeap(A);
        System.out.println(Arrays.toString(A));
        sort.heapSort(A);
        System.out.println(Arrays.toString(A));
    }

    public void  heapSort(int[] A) {
        // 先构建最大堆
        buildMaxHeap(A);
        // 初始heapSize为数组长度-1
        int heapSize = A.length - 1;
        for (int i = A.length - 1; i > 0; i--) {
            exchange(A, 0, i);
            heapSize = heapSize - 1;
            maxHeapify(A, heapSize, 0);
        }
    }

    public void buildMaxHeap(int[] A)  {
        for (int i = (A.length >> 1) - 1; i >= 0; i--) {
            maxHeapify(A, A.length - 1, i);
        }
    }

    public void buildMinHeap(int[] A)  {
        for (int i =( A.length >> 1) - 1; i >= 0; i--) {
            minHeapify(A, A.length - 1, i);
        }
    }
    /**
     * max-heapify
     * 算法导论： 6.2
     * @param A heap
     * @param i index i
     */
    public void maxHeapify(int[] A, int heapSize, int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (l <= heapSize && A[l] > A[i]) largest = l;
        else largest = i;
        if (r <= heapSize && A[r] > A[largest]) largest = r;
        if (largest != i) {
            exchange(A, i, largest);
            maxHeapify(A,  heapSize, largest);
        }
    }

    /**
     * min-heapify
     * 算法导论： 6.2-2练习
     * @param A heap
     * @param i index i
     */
    public void minHeapify(int[] A, int heapSize, int i) {
        int l = left(i);
        int r = right(i);
        int minimum;
        if (l <= heapSize && A[l] < A[i]) minimum = l;
        else minimum = i;
        if (r <= heapSize && A[r] < A[minimum]) minimum = r;
        if (minimum != i) {
            exchange(A, i, minimum);
            minHeapify(A, heapSize, minimum);
        }
    }

    public void exchange(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

    /**
     * parent(i)= (i/2)向下取整
     * 算法导论的下标是从1开始的，所以 parent 是 i/2向下取整，实际下标是从0开始
     * 所以运算前+1，运算后再-1， +1是符合运算规律， -1是得出实际数组索引下标
     * left, right 函数都遵循+1和-1的设定
     * @param i 实际数组下标
     * @return parent 数组下标
     */
    public int parent(int i) {
        return ((i + 1) >> 1) - 1;
    }

    // left(i)=2i
    public int left(int i) {
        return ((i + 1) << 1) -1;
    }

    // right(i)=2i+1
    public int right(int i) {
        return ((i + 1) << 1);
    }
}
