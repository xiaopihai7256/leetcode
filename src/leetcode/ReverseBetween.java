package leetcode;

/**
 * date: 2020/8/18
 * description: ReverseBetween
 *
 * @author xiaopihai7256
 */
public class ReverseBetween {

    public static void main(String[] args) {

        int[] array = {1};
        ListNode head = arrayToList(array);

        printListNode(reverseBetween(head, 1,1));
    }

    /**
     * https://leetcode-cn.com/problems/reverse-linked-list-ii/
     * 超越100%用户，用时0ms
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     * @param head head
     * @param m start
     * @param n end
     * @return head
     */
    static ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 0;
        ListNode mStart =  new ListNode(0);
        ListNode mPrev = null;
        ListNode left = null;
        ListNode current = head;
        ListNode right;
        while(count < n) {
            if (count == m - 1) {
                mStart.val = current.val;
                mPrev = left;
                left = mStart;
                current = current.next;
            } else if (count > m - 1 && count < n -1) {
                right = current.next;
                current.next = left;
                left = current;
                current = right;
            }  else if (count == n - 1) {
                right = current.next;
                current.next = left;
                if (mPrev != null) {
                    mPrev.next = current;
                } else {
                    head = current;
                }
                mStart.next = right;
                break;
            } else {
                left = current;
                current  = current.next;
            }
            count++;
        }
        return head;
    }

    /**
     * 辅助测试：数组转链表
     * @param arr
     * @return
     */
    static ListNode arrayToList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
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
            System.out.print(header.val);
            if (header.next != null) {
                System.out.print("->");
            }
            header = header.next;
        }
        System.out.println(']');
    }


    private static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
       }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

}
