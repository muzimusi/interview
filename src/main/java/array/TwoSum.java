package array;

import java.util.HashMap;

/*
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
public class TwoSum {
    //    暴力解法
    public int[] twoSum03(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    //    一次循环
    public int[] twoSum01(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another))
                return new int[]{map.get(another), i};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //    两次循环
    public int[] twoSum02(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int another;
        for (int i = 0; i < nums.length; i++) {
            another = target - nums[i];
            if (map.containsKey(another) && map.get(another) != i)
                return new int[]{i, map.get(another)};
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //    有序数组：对撞指针
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0, j = nums.length - 1; i < j; ) {
            if (nums[i] + nums[j] < target)
                i++;
            else if (nums[i] + nums[j] > target)
                j--;
            else {
                return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
//        int[] nums = {3, 2, 4};
        int[] res = new TwoSum().twoSum(nums, 9);
        System.out.print(res[0] + ", " + res[1]);
    }
}
