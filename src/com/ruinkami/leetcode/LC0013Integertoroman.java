package com.ruinkami.leetcode;

/**
 * Runtime: 3 ms, faster than 100.00% of Java online submissions for Roman to Integer.
 * Memory Usage: 37.3 MB, less than 34.96% of Java online submissions for Roman to Integer.
 */
public class LC0013Integertoroman {

    public int romanToInt(String s) {
        char[] strs = s.toCharArray();
        int num = 0;
        for (int i = 0; i < strs.length; i++) {
            int t = getNum(strs[i]);
            if (t == 1 || t == 10 || t == 100) {
                if (i + 1 < strs.length) {
                    int z = getNum(strs[i + 1]);
                    if (z > t) {
                        num += z - t;
                        i++;
                    } else {
                        num += t;
                    }
                } else {
                    num += t;
                }
            } else {
                num += t;
            }
        }
        return num;
    }

    public int getNum(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}
