package com.ruinkami.leetcode;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
 * Memory Usage: 31.8 MB, less than 100.00% of Java online submissions for Unique Paths.
 */
public class LC0062Uniquepaths {

    public int uniquePaths(int m, int n) {
        int total = m + n - 2; //一共要走的步数
        int down = m - 1;  //向下要走的步数
        double res = 1;
        for (int i = 1; i <= down; i++) {
            res = res * (total - down + i) / i;
        }
        return (int) res;
    }
}
