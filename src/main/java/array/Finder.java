package array;


/**
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * <p>
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 * <p>
 * 测试样例：
 * [1,3,5,2,2],5,3
 * 返回：2
 */
public class Finder {
    public int findKth(int[] a, int n, int K) {
        // write code here
        return find(a, n, K, 0, n - 1);
    }


    public int find(int[] a, int n, int k, int low, int high) {
        if (low < high) {
            int pos = partition(a, low, high);
            if (pos < n - k)
                find(a, n, k, pos + 1, high);
            else
                find(a, n, k, low, pos);
        }
        return a[n - k];
    }

    public int partition(int a[], int low, int high) {
        int pos = low;
        int key = a[pos];
        while (low < high) {
            while (low < high && a[high] >= key) high--;
            a[low] = a[high];
            while (low < high && a[low] <= key) low++;
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }

    // [begin,i]
    // [i+1,j]
    // [j+1,end]
    public int partition2(int a[], int low, int high) {
        int key = a[low];
        int i = low;
        int j = low;
        for (; j <= high; j++) {
            if (a[j] < key) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a,low,i);
        return low;
    }

    public void swap(int a[], int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        Finder finder = new Finder();
        int[] a = new int[]{1, 3, 5, 2, 2};
        print(a);
        int kth = finder.findKth(a, 5, 1);
        print(a);
        System.out.println(kth);
    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.println();
    }
}