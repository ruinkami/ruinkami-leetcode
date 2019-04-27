package com.ruinkami.leetcode;

/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for String to Integer (atoi).
 * Memory Usage: 37.1 MB, less than 23.47% of Java online submissions for String to Integer (atoi).
 */
public class LC0008Stringtointeger {

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int mark = 0;
        IntNode headNode = new IntNode(-1);
        IntNode curNode = null;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ('0' <= c && c <= '9') {
                if (curNode == null) {
                    curNode = new IntNode(c - '0');
                    headNode.next = curNode;
                } else {
                    IntNode node = new IntNode(c - '0');
                    curNode.next = node;
                    curNode = node;
                }
            } else {
                if (curNode != null || mark != 0) {
                    // 链表已经存储了部分数据 或 已经知道是负数
                    break;
                } else {
                    if (c - ' ' == 0) {
                        continue;
                    } else if (c - '+' == 0) {
                        // 记录正数标志位
                        mark = 1;
                    } else if (c - '-' == 0) {
                        // 记录负数标志位
                        mark = -1;
                    } else {
                        // 非法数据直接结束
                        return 0;
                    }
                }
            }
        }


        int y = 0;
        mark = mark == 0 ? 1 : mark;
        while (headNode.next != null) {
            if (Integer.MAX_VALUE / 10 < y  || y * 10 + mark * headNode.next.val > Integer.MAX_VALUE) {
                y = Integer.MAX_VALUE;
                break;
            } else if (Integer.MIN_VALUE / 10 > y || y * 10 + mark * headNode.next.val < Integer.MIN_VALUE) {
                y = Integer.MIN_VALUE;
                break;
            }
            y = y * 10 + mark * headNode.next.val;
            headNode = headNode.next;
        }

        if (mark > 0 && y < 0) {
            y = Integer.MAX_VALUE;
        } else if (mark < 0 && y > 0) {
            y = Integer.MIN_VALUE;
        }

        return y;
    }

    public class IntNode {
        public int val;
        public IntNode next;

        public IntNode(int v) {
            val = v;
        }
    }
}
