package string;

import java.util.HashMap;
import java.util.Map;

public class NumSum {
    public static int maxLength(int[] arr) {
        // write code here
        // 滑动窗口
        // 维护无重复元素窗口[i..j)，则[j...n-1]为待处理元素；
        // 第j元素是关键，判断是否与[i...j)之间的元素重复，可借助map实现
        int i = 0, j = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (i <= j && j < arr.length) {
            if (map.get(arr[j]) == null)
                map.put(arr[j++], 1);
            else {
                while (map.containsKey(arr[j]))
                    map.remove(arr[i++]);
            }
            res = Math.max(res, j - i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 5, 6};
        int i = maxLength(arr);
        System.out.println(i);
    }
}
