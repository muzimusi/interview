package string;

/**
 * https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac?tpId=190&&tqId=36002&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(LongestCommonSubstring("abcde", "acd"));
        System.out.println(LongestCommonSubstring("1AB2345CD","12345EF"));
        System.out.println(longestCommonSubsequence("abcde", "acd"));
    }

    public static int LongestCommonSubstring(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int max = 0;
        int index = 0;
        int dp[][] = new int[m + 1][n + 1];
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                if (text1.charAt(r - 1) == text2.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1] + 1;
                    if (max < dp[r][c]) {
                        max = dp[r][c];
                        index = c;
                    }
                    //System.out.println("c=" + c + "max=" + max);
                }
            }
        }
        System.out.println(text2.substring(index-max, index));
        return max;
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int max = 0;
        int dp[][] = new int[m + 1][n + 1];
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                if (text1.charAt(r - 1) == text2.charAt(c - 1))
                    dp[r][c] = dp[r - 1][c - 1] + 1;
                else
                    dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
                max = Math.max(max, dp[r][c]);
            }
        }
        System.out.println(max == dp[m][n]);
        return dp[m][n];
    }
}
