package  other.huawei.exam.q2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    /**
     * 堆排序， 最大元素相减，为0测清除，不为0结果回退到堆中，算出最后一个元素
     * 题目回忆：
     * 给定一个正整数数组，每次从数组取两个最大的数字相减（大的那个减小的，保证减的结果大于0）
     * 如果结果不为0，将结果放回数组中，继续重复上一步
     * 直到数组中剩余一个元素时返回这个元素，如果没有元素则返回0
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int num = Integer.parseInt(in.nextLine());
            String rawData = in.nextLine();
            System.out.println(lastNum(num, rawData));
        }
    }

    public static final Comparator<Integer> com = (x, y) -> y.compareTo(x);

    public static int lastNum(int size, String rawString) {
        PriorityQueue<Integer> priorityQueue = Arrays.stream(rawString.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(() -> {
                    return new PriorityQueue<>(size, com);
                }));
        Integer node1, node2;
        while (priorityQueue.size() > 1) {
            node1 = priorityQueue.poll();
            node2 = priorityQueue.poll();
            int num = (node1 > node2) ? node1 - node2 : node2 - node1;
            if (num != 0) {
                priorityQueue.offer(num);
            }
        }
        return priorityQueue.isEmpty() ? 0 : priorityQueue.peek();
    }


}