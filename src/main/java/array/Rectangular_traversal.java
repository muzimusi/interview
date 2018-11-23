package array;

import java.util.ArrayList;
import java.util.List;

public class Rectangular_traversal {

    public static void main(String[] args) {
        int num = 5;
        int[][] res = generateMatrix(num);
        printMatrix(res);

        List<Integer> list = travel(res);
        System.out.println(list);

    }

    //print the matrix
    private static void printMatrix(int[][] matrix) {
        int r = matrix.length;
        int l = matrix[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l; j++) {
                System.out.printf("%3d", matrix[i][j]);
                if (j == l - 1)
                    System.out.println();
            }
        }
        System.out.println();
    }

    //generate Matrix
    private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = num++;
            }
        }
        return matrix;
    }

    //Rectangular_traversal
    private static List<Integer> travel(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();

        //引导线：两横线，两竖线——》组成矩形，沿着给定矩形遍历
        for (int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1, row = 0, col = 0;
             top <= bottom && left <= right;
             top++, bottom--, left++, right--) {
            //右
            while (col < right)
                res.add(matrix[row][col++]);
            //下
            while (row < bottom)
                res.add(matrix[row++][col]);
            //左
            while (col > left)
                res.add(matrix[row][col--]);
            //上
            while (row > top + 1)
                res.add(matrix[row--][col]);
            //特殊情况:四条线汇聚到一个点
            if(top==bottom&&left==right)
                res.add(matrix[row][col]);
        }

        return res;
    }


    private static int inputEdge(int num, int[][] res, int left, int top, int right, int bottom) {
        int curRow = top;
        int curCol = left;
        if (top == bottom && left == right) {
            res[top][left] = num;
            return num;
        }


        while (curCol < right) {
            res[top][curCol++] = num++;
        }
        while (curRow < bottom) {
            res[curRow++][right] = num++;
        }
        while (curCol > left) {
            res[bottom][curCol--] = num++;
        }
        while (curRow > top) {
            res[curRow--][left] = num++;
        }
        return num;
    }
}
