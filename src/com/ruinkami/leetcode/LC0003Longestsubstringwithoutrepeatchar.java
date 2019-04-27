package com.ruinkami.leetcode;

import java.util.HashSet;

/**
 * Runtime: 8 ms, faster than 88.38% of Java online submissions for Longest Substring Without Repeating Characters.
 * Memory Usage: 37.7 MB, less than 42.40% of Java online submissions for Longest Substring Without Repeating Characters.
 */

public class LC0003Longestsubstringwithoutrepeatchar {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashSet<Character> charSets =  new HashSet<>();
        char[] chars = s.toCharArray();
        int maxLength = 1;
        int iStart = 0;
        int iEnd = 1;
        charSets.add(chars[iStart]);
        while (iEnd < chars.length) {
            if (charSets.contains(chars[iEnd])) {
                charSets.remove(chars[iStart]);
                iStart++;
                continue;
            } else {
                charSets.add(chars[iEnd]);
                maxLength = maxLength < iEnd - iStart + 1 ? iEnd - iStart + 1 : maxLength;
                iEnd++;
            }
        }
        return maxLength;
    }
}
