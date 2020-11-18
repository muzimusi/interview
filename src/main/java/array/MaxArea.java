package array;

/**
 * 【leetcode】
 * 11. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 【nowcoder】
 * 容器盛水问题
 * https://www.nowcoder.com/practice/31c1aed01b394f0b8b7734de0324e00f?tpId=190&&tqId=36005&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 */
public class MaxArea {
    // leetcode 暴力
    public static int maxArea11(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return ans;
    }

    // leetcode 双指针
    public static int maxArea12(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return maxArea;
    }

    // nowcoder 暴力
    public static int maxArea21(int[] height) {
        int maxArea = 0;

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {3, 1, 2, 5, 2, 4};
        System.out.println(maxArea11(height));
        System.out.println(maxArea21(height));
    }
}
