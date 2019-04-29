package com.ruinkami.leetcode;

/**
 * Runtime: 5 ms, faster than 68.73% of Java online submissions for Integer to Roman.
 * Memory Usage: 37.8 MB, less than 100.00% of Java online submissions for Integer to Roman.
 */
public class LC0012Romantointeger {

    int[] digits = new int[]{1, 5, 10, 50, 100, 500, 1000};
    String[] strs = new String[]{"I", "V", "X", "L", "C", "D", "M"};

    public String intToRoman(int num) {
        return calRomanStr(num, 6);
    }

    public String calRomanStr(int num, int index) {
        String s = "";

        while (index >= 0) {
            int temp = num / digits[index];
            for (int i = 0; i < temp; i++) {
                s += strs[index];
            }
            num = num % digits[index];

            int opDigitIndex = -1;
            if (index - 1 >= 0 && digits[index] == 5 * digits[index - 1]) {
                opDigitIndex = index - 1;
            } else if (index - 2 >= 0 && digits[index] == 10 * digits[index - 2]) {
                opDigitIndex = index - 2;
            }

            if (opDigitIndex != -1 && num >= digits[index] - digits[opDigitIndex]) {
                s += strs[opDigitIndex] + strs[index];
                num -= digits[index] - digits[opDigitIndex];
            }

            index--;
        }
        return s;
    }
}
