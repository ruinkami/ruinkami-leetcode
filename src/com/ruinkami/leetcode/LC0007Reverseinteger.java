package com.ruinkami.leetcode;

/**
 * Runtime: 2 ms, faster than 78.08% of Java online submissions for Reverse Integer.
 * Memory Usage: 35.3 MB, less than 100.00% of Java online submissions for Reverse Integer.
 */
public class LC0007Reverseinteger {
    public int reverse(int x) {
        boolean negative = x < 0;
        x = negative ? -x : x;

        IntNode tailNode = new IntNode(-1);
        IntNode curNode = null;
        int num = x;
        while (num != 0) {
            IntNode node = new IntNode(num % 10);
            if (curNode != null) {
                curNode.next = node;
            }
            node.prev = curNode != null ? curNode : null;
            curNode = node;
            num = num / 10;
            if (num == 0) {
                tailNode.prev = curNode;
            }
        }

        int y = 0;
        int times = 0;
        while (tailNode.prev != null) {
            if (times >= 10) return 0;
            if (y + tailNode.prev.val * Math.pow(10, times) > Integer.MAX_VALUE || y + tailNode.prev.val * Math.pow(10, times) < Integer.MIN_VALUE) {
                y = 0;
                break;
            }
            y += tailNode.prev.val * Math.pow(10, times);
            times++;
            tailNode = tailNode.prev;
        }

        if (negative) y = -y;
        return y;
    }

    public class IntNode {
        public int val;
        public IntNode prev;
        public IntNode next;

        public IntNode(int v) {
            val = v;
        }
    }
}
