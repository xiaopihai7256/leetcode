package leetcode;

/**
 * MergeKLists
 * src: https://leetcode-cn.com/problems/merge-k-sorted-lists/submissions/
 * Date: 2019/11/18
 * Description: 23-合并K个排序链表
 */

public class MergeKLists {

    public static void main(String[] args) {
        MergeKLists test = new MergeKLists();
        int[][] data = {
                {1,4,5},{1,3,4},{2,6}
        };
        test.mergeKLists(batchArrayToList(data));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeSort(lists, 0, lists.length - 1);
    }

    /**
     * 合并多个链表，思路来源于 归并排序, 使用递归分解问题，最后再合并
     * @param lists 原始链表集合
     * @param p 起始节点
     * @param r 末尾节点
     * @return 合并结果
     */
    public ListNode mergeSort(ListNode[] lists, int p, int r) {
        if (p == r) return lists[p];
        else if (r - p == 1) return merge(lists[p], lists[r]);
        if (p < r) {
            int q = (p + r) / 2;
            ListNode left = mergeSort(lists, p, q);
            ListNode right = mergeSort(lists, q + 1, r);
            return merge(left, right);
        }
        return null;
    }

    /**
     * 合并链表， 思路来源于归并排序中的merge方法
     * @param first
     * @param second
     * @return
     */
    public ListNode merge(ListNode first, ListNode second) {
        if (first == null) return second;
        else if (second == null) return first;
        ListNode header = first, firstLast = first, temp;
        // 避免在迭代中一直判断 first == last, 直接判断后交换位置
        if (first.val > second.val) {
            temp = first;
            first = second;
            second = temp;
            header = first;
        }
        while (second != null) {
            // first 为空时，直接拼接second剩余部分
            if (first == null ) {
                firstLast.next = second;
                break;
            }
            if (first.val <= second.val) {
                firstLast = first;
                first = first.next;
                continue;
            }
            firstLast.next = second;
            temp = second.next;
            second.next = first;
            firstLast = second;
            second = temp;
        }
        // printListNode(header);
        return header;

    }

    /**
     * 辅助测试：数组转链表
     * @param arr
     * @return
     */
    static ListNode arrayToList(int[] arr) {
        ListNode header = new ListNode(arr[0]);
        ListNode temp = header;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return header;
    }

    /**
     * 辅助测试：矩阵转链表数组
     * @param arrList
     * @return
     */
    static ListNode[] batchArrayToList(int[][] arrList) {
        ListNode[] list = new ListNode[arrList.length];
        int i = 0;
        for (int[] arr : arrList) {
            list[i++] = arrayToList(arr);
        }
        return list;
    }

    /**
     * 打印链表到控制台
     * @param header
     */
    static void printListNode(ListNode header) {
        System.out.print('[');
        while (header != null) {
            System.out.print(header.val + "->");
            header = header.next;
        }
        System.out.println(']');
    }

    /**
     * 链表类
     */
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

}
