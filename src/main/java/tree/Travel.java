package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 分别按照二叉树先序，中序和后序打印所有的节点。
 */
public class Travel {
    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */

    // 方法一
//    public int[][] threeOrders(TreeNode root) {
//        int[] first = firstTravel(root);
//        int[] mid = midTravel(root);
//        int[] after = afterTravel(root);
//        int[][] res = new int[3][];
//        res[0] = first;
//        res[1] = mid;
//        res[2] = after;
//        return res;
//    }
//
//    public int[] firstTravel(TreeNode root) {
//        if (root == null)
//            return new int[]{};
//        int[] left = firstTravel(root.left);
//        int[] right = firstTravel(root.right);
//        int n = 1 + left.length + right.length;
//        int[] res = new int[n];
//        // 前序操作
//        res[0] = root.val;
//        for (int i = 0; i < left.length; i++) {
//            res[i + 1] = left[i];
//        }
//        for (int i = 0; i < right.length; i++) {
//            res[left.length + 1 + i] = right[i];
//        }
//        return res;
//    }
//
//    public int[] midTravel(TreeNode root) {
//        if (root == null)
//            return new int[]{};
//        int[] left = midTravel(root.left);
//        int[] right = midTravel(root.right);
//        int n = 1 + left.length + right.length;
//        int[] res = new int[n];
//        // 中序操作
//        for (int i = 0; i < left.length; i++) {
//            res[i] = left[i];
//        }
//        res[left.length] = root.val;
//        for (int i = 0; i < right.length; i++) {
//            res[left.length + 1 + i] = right[i];
//        }
//        return res;
//    }
//
//    public int[] afterTravel(TreeNode root) {
//        if (root == null)
//            return new int[]{};
//        int[] left = afterTravel(root.left);
//        int[] right = afterTravel(root.right);
//        int n = 1 + left.length + right.length;
//        int[] res = new int[n];
//        // 后序操作
//        for (int i = 0; i < left.length; i++) {
//            res[i] = left[i];
//        }
//        for (int i = 0; i < right.length; i++) {
//            res[left.length + i] = right[i];
//        }
//        res[left.length + right.length] = root.val;
//        return res;
//    }

    // 方法二
//    public int[][] threeOrders(TreeNode root) {
//        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
//        list.add(new ArrayList<Integer>());
//        list.add(new ArrayList<Integer>());
//        list.add(new ArrayList<Integer>());
//        travel(root, list);
//        int[][] res = new int[3][list.get(0).size()];
//        for (int i = 0; i < list.get(0).size(); i++) {
//            res[0][i] = list.get(0).get(i);
//            res[1][i] = list.get(1).get(i);
//            res[2][i] = list.get(2).get(i);
//        }
//        return res;
//    }
//    public void travel(TreeNode root, List<List<Integer>> list) {
//        if (root == null)
//            return;
//        list.get(0).add(root.val);
//        travel(root.left, list);
//        list.get(1).add(root.val);
//        travel(root.right, list);
//        list.get(2).add(root.val);
//    }

    // 方法三
    int preIndex = 0;
    int midIndex = 0;
    int postIndex = 0;

    public int count(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + count(root.left) + count(root.right);
    }

    public int[][] threeOrders(TreeNode root) {
        int n = count(root);
        int[][] res = new int[3][n];
        travel(root, res);
        return res;
    }

    public void travel(TreeNode root, int[][] res) {
        if (root == null)
            return;
        res[0][preIndex++] = root.val;
        travel(root.left, res);
        res[1][midIndex++] = root.val;
        travel(root.right, res);
        res[2][postIndex++] = root.val;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree();
        Travel t = new Travel();

        int[][] orders = t.threeOrders(root);
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < orders[j].length; i++) {
                System.out.printf("%d", orders[j][i]);
            }
            System.out.println();
        }
    }
}
