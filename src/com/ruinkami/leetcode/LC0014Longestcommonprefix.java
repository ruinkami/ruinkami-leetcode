package com.ruinkami.leetcode;

/**
 * Runtime: 1 ms, faster than 90.54% of Java online submissions for Longest Common Prefix.
 * Memory Usage: 37.4 MB, less than 79.09% of Java online submissions for Longest Common Prefix.
 */
public class LC0014Longestcommonprefix {
    public String longestCommonPrefix(String[] strs) {
        int curCommonIndex = 0;
        char[] curCommonChars = null;
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            if (curCommonChars == null) {
                curCommonChars = chars;
                curCommonIndex = chars.length - 1;
                continue;
            }

            if (chars.length - 1 < curCommonIndex) {
                curCommonIndex = chars.length - 1;
            }
            for (int j = 0; j <= curCommonIndex; j++) {
                if (chars[j] - curCommonChars[j] != 0) {
                    curCommonIndex = j - 1;
                    break;
                }
            }
        }

        if (curCommonIndex < 0 || curCommonChars == null) {
            return "";
        } else {
            String s = "";
            for (int i = 0; i <= curCommonIndex; i++) {
                s += curCommonChars[i];
            }
            return s;
        }
    }
}
