package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.ToIntFunction;

/**
 * date: 2020/8/22
 * description: 出现频率最高的k个元素, 堆自己实现，未采用JDK的Queue
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @author xiaopihai7256
 */
public class TopKFrequent {

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 4, 5, 4, 6};
        int[] result = topKFrequent(a, 2);
        System.out.println(Arrays.toString(result));
    }

    public static class IntNode {
        public IntNode() {
            this.val = 0;
        }
        int val;
    }

    public static final ToIntFunction<Map.Entry<Integer, IntNode>> toInt = entry -> entry.getValue().val;

    /**
     * 执行用时： * 16 ms * , 在所有 Java 提交中击败了 * 80.25% * 的用户
     * 内存消耗： * 42.3 MB * , 在所有 Java 提交中击败了 * 54.42% * 的用户
     */
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, IntNode> frequentHash = new HashMap<>();
        for (int num : nums) {
            IntNode node = frequentHash.computeIfAbsent(num, v -> new IntNode());
            node.val++;
        }
        // 这里自己实现了一个堆，可以用jdk自带的PriorityQueue简化代码
        Map.Entry<Integer, IntNode>[] heap = new Map.Entry[k];
        // 题目说明K肯定有效，所以先压入K个元素，构建初始堆
        Iterator<Map.Entry<Integer, IntNode>> iterator = frequentHash.entrySet().iterator();
        for (int i = 0; i < k; i++) {
            heap[i] = iterator.next();
        }
        buildHeap(heap, toInt);
        // 压入剩余元素
        while(iterator.hasNext()) {
            Map.Entry<Integer, IntNode> current = iterator.next();
            if (toInt.applyAsInt(current) > toInt.applyAsInt(heap[0])) {
                heap[0] = current;
                minHeapify(heap,0, toInt);
            }
        }
        // 构造结果
        int[] kArr = new int[k];
        for (int i = 0; i < k; i++) {
            kArr[i] = heap[i].getKey();
        }
        return kArr;
    }

    /**
     * 构建堆
     */
    public static <T> void buildHeap(T[] array, ToIntFunction<T> toInt) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            minHeapify(array, i, toInt);
        }
    }

    /**
     * 最小堆化
     */
    public static <T> void minHeapify(T[] array, int index, ToIntFunction<T> toInt) {
        int left = ((index + 1) << 1) - 1;
        int right = ((index + 1) << 1);
        int min;
        int heapSize = array.length - 1;
        if (left <= heapSize && toInt.applyAsInt(array[left]) < toInt.applyAsInt(array[index])) {
            min = left;
        } else {
            min = index;
        }
        if (right <= heapSize && toInt.applyAsInt(array[right]) < toInt.applyAsInt(array[min])) {
            min = right;
        }
        if (index != min) {
            T temp = array[index];
            array[index] = array[min];
            array[min] = temp;
            minHeapify(array, min, toInt);
        }
    }


}
