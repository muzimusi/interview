package integer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 【343】 Integer Break
 */
public class IntegerBreak {
    private static int[] memo;

    //将n进行分割(至少分割成两部分)，可以获得的最大乘积
    public static int breakInteger2(int n) {
        if (memo[n - 1] != 0)
            return memo[n - 1];

        int res = n;
        for (int i = 1; i <= n - 1; i++)
            //i+(n-i)
            res = Math.max(res, i * breakInteger(n - i));
        memo[n - 1] = res;
        return res;
    }

    //将n进行分割(至少分割成两部分)，可以获得的最大乘积
    public static int breakInteger(int n) {

        if (memo[n] != 0)
            return memo[n];

        int res = n;
        for (int i = 1; i <= n - 1; i++)
            //i+(n-i)
            res = Math.max(res, i * breakInteger(n - i));
        memo[n] = res;
        return res;
    }

    public static int integerBreak(int n) {
        int res = n;
        for (int i = 1; i <= n - 1; i++)
            res = Math.max(res, i * breakInteger(n - i));
        return res;
    }

    public static void main(String[] args) {
        int n = 1;
        memo = new int[n];
        System.out.println(breakInteger2(n));
        System.out.println(integerBreak(n));
    }
}
