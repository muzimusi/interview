package string;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 3 M
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * *
 * 示例 1:
 * *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
public class LongestSubstringWithoutRepeatingCharacters {


    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters instance =
                new LongestSubstringWithoutRepeatingCharacters();
        instance.lengthOfLongestSubstring("abcabcbb");
        instance.lengthOfLongestSubstring("acbcabcde");
        instance.lengthOfLongestSubstring("aabbccdd");
        instance.lengthOfLongestSubstring("aaa");
        instance.lengthOfLongestSubstring("abcabcdacd");
        instance.lengthOfLongestSubstring("a");
        instance.lengthOfLongestSubstring("abc");
        instance.lengthOfLongestSubstring("abcdabcd");
        instance.lengthOfLongestSubstring("13125");
    }

    int l = 0, r = 0, max = 0;

    // 滑动窗口
    // [i,j] 无重复
    // [j+1,end] 未知
    public int lengthOfLongestSubstring(String str) {
        l = r = max = 0;
        int n = str.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(str.charAt(i), 0);
        }
        for (int i = 0, j = 0; i <= j && i < n && j < n; ) {
            if (map.get(str.charAt(j)) == 0)
                map.put(str.charAt(j++), 1);
            else
                map.put(str.charAt(i++), 0);
            update(i, j);
        }
        System.out.printf(str + ":" + max + " ");
        for (int k = l; k <= r; k++) {
            System.out.printf("%c", str.charAt(k));
        }
        System.out.println();
        return max;
    }

    public void update(int l, int r) {
        if (r - l > max) {
            max = r - l;
            this.l = l;
            this.r = r - 1;
        }
    }

    // 滑动窗口 优化
    // [i,j] 无重复
    // [j+1,end] 未知
    public int lengthOfLongestSubstring2(String str) {
        int i = 0, j = 0, n = str.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (; i <= j && i < n && j < n; ) {
            char c = str.charAt(j);
            if (!isContains(map, str, j)) {
                map.put(c, j);
                j++;
                continue;
            }
            update(i, j);

            left = map.get(c);
            i = left + 1;
            j++;

        }
        System.out.println(max);
        for (int k = l; k <= r; k++) {
            System.out.printf("%c ", str.charAt(k));
        }
        return max;
    }

    //[...i..k..j,j+1...end]
    int left = 0;

    public boolean isContains(Map<Character, Integer> map, String str, int index) {
        if (map.get(str.charAt(index)) == null || map.get(str.charAt(index)) < left) {
            map.put(str.charAt(index), index);
            return false;
        }
        return map.get(str.charAt(index)) != null;
    }

}
