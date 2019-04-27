package com.ruinkami.leetcode;

/**
 * Runtime: 2 ms, faster than 97.89% of Java online submissions for Container With Most Water.
 * Memory Usage: 40.2 MB, less than 66.42% of Java online submissions for Container With Most Water.
 */
public class LC0011Containerwithmostwater {
    public int maxArea(int[] height) {
        int m = 0;
        int i = 0;
        int j = height.length - 1;
        while (i != j) {
            int temp = (height[j] < height[i] ? height[j] : height[i]) * (j - i);
            if (temp > m) {
                m = temp;
            }
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return m;
    }
}
