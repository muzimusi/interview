package array;

/**
 * 请实现有重复数字的有序数组的二分查找。
 * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
 * <p>
 * 输入
 * 5,4,[1,2,4,4,5]
 * <p>
 * 输出  3
 */
public class BinarySearch {
    /**
     * 二分查找
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_2(int n, int v, int[] a) {
        if (a == null)
            return 1;
        return search(0, a.length - 1, v, a) + 1;
    }

    public int upper_bound_(int n, int v, int[] a) {
        int left = 0;
        int right = n - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (a[mid] < v) {
                left = mid + 1;
            } else if (v < a[mid]) {
                right = mid - 1;
            } else if (v == a[mid]) {
                right = mid - 1;
            }
        }
        return left + 1;
    }

//    public int upper_bound_ (int n, int v, int[] a) {
//        // write code here
//        if(v > a[n - 1]) {
//            return n + 1;
//        }
//        int low = 0, high = n;
//        while (low < high) {
//            int mid = low + (high - low) / 2;
//            if (a[mid] < v) {
//                low = mid + 1;
//            } else {
//                high = mid;
//            }
//        }
//        return low + 1;
//    }

    private int search(int left, int right, int value, int[] array) {
        if (array == null || array.length == 0)
            return 0;
        if (left > right)
            return array.length;
        if (left == right)
            return array[left] == value ? left : array.length;

        int mid = (left + right) / 2;
        if (array[mid] < value)
            return search(mid + 1, right, value, array);
        else if (array[mid] > value)
            return search(left, mid - 1, value, array);
        else if (array[mid] == value) {
            int count = 0;
            for (int i = mid; i >= 0; i--)
                if (array[i] == value)
                    count++;

            return mid - (count - 1);
        }
        return array.length;
    }

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();

        int[] array = new int[]{1, 1, 2, 2, 3};
        System.out.println(search.upper_bound_(array.length, 0, array));
        System.out.println(search.upper_bound_(array.length, 1, array));
        System.out.println(search.upper_bound_(array.length, 2, array));
        System.out.println(search.upper_bound_(array.length, 3, array));
        System.out.println(search.upper_bound_(array.length, 4, array));
        System.out.println();

        array = new int[]{1, 2, 3};
        System.out.println(search.upper_bound_(array.length, 0, array));
        System.out.println(search.upper_bound_(array.length, 1, array));
        System.out.println(search.upper_bound_(array.length, 2, array));
        System.out.println(search.upper_bound_(array.length, 3, array));
        System.out.println(search.upper_bound_(array.length, 4, array));
        System.out.println();

        array = new int[]{1, 2, 4};
        System.out.println(search.upper_bound_(array.length, 3, array));
        System.out.println();

        array = new int[]{2};
        System.out.println(search.upper_bound_(array.length, 1, array));
        System.out.println(search.upper_bound_(array.length, 2, array));
        System.out.println(search.upper_bound_(array.length, 1, array));
        System.out.println();

        array = new int[]{};
        System.out.println(search.upper_bound_(array.length, 3, array));
        System.out.println(search.upper_bound_(0, 3, null));
        System.out.println();

        array = new int[]{2, 2, 2, 2};
        System.out.println(search.upper_bound_(array.length, 2, array));
        System.out.println();

        array = new int[]{2, 3, 4, 4, 4, 7, 7, 8, 10, 10, 11, 12, 13, 14, 15, 15, 17, 18, 19, 23, 24, 24, 24, 24, 25, 26, 26, 26, 27, 27, 28, 29, 29, 30, 33, 36, 38, 38, 40, 40, 41, 43, 43, 43, 44, 46, 46, 47, 51, 52, 52, 53, 54, 56, 57, 57, 57, 58, 58, 61, 61, 61, 62, 64, 64, 66, 66, 67, 67, 67, 70, 72, 74, 74, 74, 75, 75, 78, 78, 78, 79, 79, 80, 83, 83, 83, 83, 84, 84, 86, 88, 89, 89, 90, 91, 91, 92, 93, 93, 96};
        System.out.println(search.upper_bound_(array.length, 1, array));


    }
}
