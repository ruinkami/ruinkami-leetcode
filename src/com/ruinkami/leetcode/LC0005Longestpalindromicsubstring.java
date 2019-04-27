package com.ruinkami.leetcode;

/**
 * Runtime: 4 ms, faster than 99.75% of Java online submissions for Longest Palindromic Substring.
 * Memory Usage: 37.2 MB, less than 95.09% of Java online submissions for Longest Palindromic Substring.
 * Manacher算法
 * https://mp.weixin.qq.com/s?__biz=MzIzMTE1ODkyNQ==&mid=2649410225&idx=1&sn=ed045e8edc3c49a436a328e5f0f37a55&chksm=f0b60f53c7c18645b4c04a69ad314723cce94ed56994d6f963c2275a2db8d85f973f15f508e4&mpshare=1&scene=23&srcid=1001JCsBlpxgUWjgixasChNQ#rd
 */

public class LC0005Longestpalindromicsubstring {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();

        // 第一步 将数组例如 "babad"处理为"#b#a#b#a#d#" 这样已有奇/偶回文数均变为奇数回文 简化扩展算法
        char[] formedChars = new char[chars.length * 2 + 1];
        for (int i = 0; i < chars.length; i++) {
            formedChars[i * 2] = '#';
            formedChars[i * 2 + 1] = chars[i];
        }
        formedChars[chars.length * 2] = '#';

        int[] radius = new int[formedChars.length]; // 记录已知的每个位置最大回文字符串长度的半径
        int cur = 0; // 记录当前回文中心位置
        int maxRadiusIndex = 0;

        for (int i = 0; i < formedChars.length; i++) {

            int offset = 0;
            boolean needChangeCur = false;

            if (i == 0) {
                cur = i;
                radius[i] = 0;
                maxRadiusIndex = 0;
            } else if (i <= cur + radius[cur]) { // 说明当前index在已知回文知识范围内
                // 找到i相对于cur的镜像位置j
                int j = cur * 2 - i;
                // 推理得到i位在已有回文记录内的最小回文长度
                int minRadius = j - radius[j] > cur - radius[cur] ? radius[j] : j - cur + radius[cur];
                offset = minRadius;
            } else { // 说明当前index在已知回文知识范围外
                needChangeCur = true;
                offset = 0;
            }

            while (i - offset - 1 >= 0 && i + offset + 1 < formedChars.length) { // 证明还可以向两端扩展
                if (formedChars[i - offset - 1] == formedChars[i + offset + 1]) {
                    offset++;
                } else {
                    break;
                }
            }

            radius[i] = offset;
            maxRadiusIndex = radius[maxRadiusIndex] < offset ? i : maxRadiusIndex;

            if (needChangeCur || cur + radius[cur] < i + radius[i]){ // i的知识边界超过了cur
                cur = i;
            }

        }

        char[] charResult = new char[radius[maxRadiusIndex]];
        int j = 0;
        for (int i = maxRadiusIndex - radius[maxRadiusIndex]; i < maxRadiusIndex + radius[maxRadiusIndex]; i++) {
            if (formedChars[i] != '#') {
                charResult[j] = formedChars[i];
                j++;
            }
        }

        return String.copyValueOf(charResult);
    }
}
