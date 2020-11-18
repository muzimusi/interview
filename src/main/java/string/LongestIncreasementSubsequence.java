package string;

/**
 * 来源：力扣（LeetCode）
 * 300. 最长上升子序列
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */


import java.util.Arrays;

/**
 * 最长递增子序列
 * 给定数组arr，设长度为n，输出arr的最长递增子序列。（如果有多个答案，请输出其中字典序最小的）
 * https://www.nowcoder.com/practice/9cf027bf54714ad889d4f30ff0ae5481?tpId=190&&tqId=35211&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 * <p>
 * 例如
 * [1,2,8,6,4]
 * [1,2,4]
 * 其最长递增子序列有3个，（1，2，8）、（1，2，6）、（1，2，4）其中第三个字典序最小，故答案为（1，2，4）
 */
public class LongestIncreasementSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1, 2, 8, 6, 4}));
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));

        printNums(ContentOfLIS(new int[]{1, 2, 8, 6, 4}));
        printNums(ContentOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    // leetCode
    // O(n2)解法
    // https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i]表示以nums[i]结尾的LIS长度。
        // 状态转移方程: dp[i] = max(dp[j])+1; nums[j]<nums[i],0<=j<i
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return dp[n - 1];
    }

    public static int[] ContentOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i]表示以nums[i]结尾的LIS长度。
        // 状态转移方程: dp[i] = max(dp[j])+1; nums[j]<nums[i],0<=j<i
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        // 逆序输出
        int len = dp[n - 1];
        int[] res = new int[len];
        for (int i = dp.length - 1; i >= 0; i--) {
            res[--len] = nums[i];
            // dp值与前面相等时忽略
            while (i > 0 && dp[i] == dp[i - 1])
                i--;
        }
        return res;
    }

    public static void printNums(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println(nums[nums.length - 1] + "]");
    }
}
