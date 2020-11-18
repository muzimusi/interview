package string;

public class SimulateBigNumberAdd {
    public static String solve(String s, String t) {
        // write code here
        int sS = s.length();
        int tS = t.length();
        int carry = 0;
        int sum = 0, n = Math.max(sS, tS) + 1;
        int r = n - 1;
        char[] res = new char[n];
        for (int i = sS - 1, j = tS - 1; i >= 0 || j >= 0; i--, j--) {
            int a = i >= 0 ? s.charAt(i) - '0' : 0;
            int b = j >= 0 ? t.charAt(j) - '0' : 0;
            sum = a + b + carry;
            res[r--] = (char) (sum % 10 + '0');
            carry = sum / 10;
        }
        if (carry == 1) {
            res[r] = '1';
            return String.valueOf(res);
        }
        return String.valueOf(res).substring(1);
    }

    public static void main(String[] args) {
        System.out.println(solve("98", "1"));
        System.out.println(solve("1258994789086810959258888307221656691275942378416703768", "7007001981958278066472683068554254815482631701142544497"));
    }
}
