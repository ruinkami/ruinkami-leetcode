package com.ruinkami.leetcode;

/**
 * Runtime: 2 ms, faster than 96.13% of Java online submissions for Add Two Numbers.
 * Memory Usage: 46.7 MB, less than 52.03% of Java online submissions for Add Two Numbers.
 */

public class LC0002Addtwonum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = buildNextNode(l1, l2, 0);
        return l3;
    }

    private ListNode buildNextNode(ListNode l1, ListNode l2, int add) {
        ListNode node;
        int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + add;
        int val = sum % 10;
        int overDigit = sum / 10;

        node = new ListNode(val);
        if ((l1 == null || l1.next == null) && (l2 == null || l2.next == null) && overDigit == 0) {
            node.next = null;
        } else {
            node.next = buildNextNode(l1 != null ? l1.next : null, l2 != null ? l2.next : null, overDigit);
        }
        return node;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
