package com.ruinkami.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Letter Combinations of a Phone Number.
 * Memory Usage: 37 MB, less than 88.90% of Java online submissions for Letter Combinations of a Phone Number.
 */
public class LC0017Lettercombinationsphonenumber {

    /**
     * 2 = asc 50 ---> a,b,c   = asc 97-99
     * 3 = asc 51 ---> d,e,f   = asc 100-102
     * 4 = asc 52 ---> g,h,i   = asc 103-105
     * 5 = asc 53 ---> j,k,l   = asc 106-108
     * 6 = asc 54 ---> m,n,o   = asc 109-111
     * 7 = asc 55 ---> p,q,r,s = asc 112-115
     * 8 = asc 56 ---> t,u,v   = asc 116-118
     * 9 = asc 57 ---> w,x,y,z = asc 119-122
     */

    List<String> list = new ArrayList<>();
    char[] digitChars;

    public List<String> letterCombinations(String digits) {
        digitChars = digits.toCharArray();
        buildResult(0, new char[digits.length()]);
        return list;
    }

    public void buildResult(int index, char[] letterChars) {
        if (index < digitChars.length) {
            char c = digitChars[index];
            for (int i = minLetterAsc(c); i <= maxLetterAsc(c); i++) {
                letterChars[index] = (char) i;
                buildResult(index + 1, letterChars);
            }
        } else {
            String s = new String(letterChars);
            if (s != null && !s.equals("")) {
                list.add(s);
            }
        }
    }

    public static int minLetterAsc(char c) {
        int asc = 97 + (c - 50) * 3;
        if (c >= 56) {
            asc = asc + 1;
        }
        return  asc;
    }

    public static int maxLetterAsc(char c) {
        int asc = 96 + (c - 49) * 3;
        if (c == 57) {
            asc = asc + 2;
        } else if (c >= 55) {
            asc = asc + 1;
        }
        return asc;
    }

}
