package array;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 */
public class MaxLengthWithoutRepeat {
    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
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

//                while (arr[i]!=arr[j]){
//                    i++;
//                }
//                map.remove(arr[i]);
            }
            res = Math.max(res, j - i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 5, 6};
        System.out.println(maxLength(arr));
    }
}
