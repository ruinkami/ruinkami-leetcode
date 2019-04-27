package com.ruinkami.leetcode;

/**
 * Runtime: 3 ms, faster than 76.23% of Java online submissions for Median of Two Sorted Arrays.
 * Memory Usage: 46.6 MB, less than 94.98% of Java online submissions for Median of Two Sorted Arrays.
 */
public class LC0004Medianoftwosortedarrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sumSize = (nums1 != null ? nums1.length : 0) + (nums2 != null ? nums2.length : 0);
        int m1No; // No.? 从1开始 非index
        int m2No; // No.? 从1开始 非index
        if (sumSize % 2 == 0) {
            m1No = sumSize / 2;
            m2No = m1No + 1;
        } else {
            m1No = sumSize / 2 + 1;
            m2No = m1No;
        }

        if (nums1 == null || nums1.length == 0) {
            return avg(nums2[m1No - 1], nums2[m2No - 1]);
        } else if (nums2 == null || nums2.length == 0) {
            return avg(nums1[m1No - 1], nums1[m2No - 1]);
        }

        int i = -1;
        int j = -1;
        boolean curNums; // true代表目前在nums1, false代表目前在nums 2

        // TODO 这里假设了nums1和nums2都是从小到大排列 如果有问题再做处理

        if (nums1[i + 1] <= nums2[j + 1]) {
            i++;
            curNums = true;
        } else {
            j++;
            curNums = false;
        }

        while (true) {
            if (i + j + 2 == m1No) {
                // 说明已经达到中位数位置
                int m1 = curNums ? nums1[i] : nums2[j];
                if (m1No == m2No) {
                    return avg(m1, m1);
                } else {
                    if (i + 1 >= nums1.length) { // nums1已经没有元素
                        return avg(m1, nums2[j+1]);
                    } else if (j + 1 >= nums2.length) { // nums2已经没有元素
                        return avg(m1, nums1[i+1]);
                    } else {
                        return avg(m1, nums1[i+1] <= nums2[j+1] ? nums1[i+1] : nums2[j+1]);
                    }
                }
            } else {
                if (i + 1 >= nums1.length) { // nums1已经没有元素
                    j++;
                    curNums = false;
                } else if (j + 1 >= nums2.length) { // nums2已经没有元素
                    i++;
                    curNums = true;
                } else {
                    if (nums1[i+1] <= nums2[j+1]) {
                        i++;
                        curNums = true;
                    } else {
                        j++;
                        curNums = false;
                    }
                }
            }
        }
    }

    public double avg(int i1, int i2) {
        return ((double) (i1 + i2) / 2);
    }

}
