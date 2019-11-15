package leetcode;

/**
 * AddTwoNumbers
 *
 * @author huifei.liu@hand-chian.com
 * Date: 2019-06-16
 * Description: leetcode 2
 */

public class AddTwoNumbers {

    public static void main(String[] args) {


        ListNode sum = addTwoNumbers2(toListNode(new int[]{5}), toListNode(new int[]{5}));
        ListNode temp = sum;
        System.out.print(sum.val + ",");
        while (temp.next != null) {
            temp = temp.next;
            System.out.print(temp.val + ",");
        }
    }


    public static ListNode toListNode(int[] arr) {

        ListNode header = new ListNode(arr[0]);
        ListNode next = header;
        for (int i = 1; i < arr.length; i++) {
            next.next = new ListNode(arr[i]);
            next = next.next;
        }
        return header;
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode resultHeader = new ListNode(0);
        ListNode next1 = l1, next2 = l2, sumNext = resultHeader;
        int up, sum;
        boolean doSum = true;
        while (doSum) {

            if (next1 == null && next2 != null) {
                sum = sumNext.val + next2.val;
                next2 = next2.next;
            } else if (next1 != null && next2 == null) {
                sum = sumNext.val + next1.val;
                next1 = next1.next;
            } else {
                sum = next1.val + next2.val + sumNext.val;
                next1 = next1.next;
                next2 = next2.next;
            }
            up = sum / 10;
            sumNext.val = up > 0 ? sum - 10 : sum;
            if ((doSum = next1 != null || next2 != null) || up > 0) {
                sumNext.next = new ListNode(up);
                sumNext = sumNext.next;
            }

        }
        return resultHeader;
    }


    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode resultHeader = new ListNode(0);
        ListNode next1 = l1, next2 = l2, sumNext = resultHeader;
        boolean doSum = true;
        // 先加一边，不考虑进位
        while (doSum) {
            if (next1 == null && next2 != null) {
                sumNext.val =next2.val;
                next2 = next2.next;
            } else if (next1 != null && next2 == null) {
                sumNext.val = next1.val;
                next1 = next1.next;
            } else {
                sumNext.val = next1.val + next2.val;
                next1 = next1.next;
                next2 = next2.next;
            }
            if (doSum = next1 != null || next2 != null) {
                sumNext.next = new ListNode(0);
                sumNext = sumNext.next;
            }

        }

        sumNext = resultHeader;
        boolean up = resultHeader.val >= 10;
        while (sumNext != null) {
            if (up) {
                sumNext.val -= 10;
            }
            up = sumNext.val >= 10;
            if (up) {
                if (sumNext.next == null) {
                    sumNext.next = new ListNode(1);
                } else {
                    sumNext.next.val += 1;
                }
            }
            sumNext = sumNext.next;
        }

        return resultHeader;
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
