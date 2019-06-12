package string;

import org.junit.Test;
/**
 * 去掉字符串中连续出现的k个0的子串
 * 例子:
 * A00B K=2 -> AB
 * A0000B000 K=3 -> A0000B
 */
public class RemoveKZeros {
    //ascii 0 表示null
    @Test
    public void fun() {
        char[] chars = {'1', '0', '0', '2'};
        chars[1] = 97;
        chars[2] = 0;
        String value = String.valueOf(chars);
        System.out.println(value);
        int index = "abcdabcd".indexOf("cdab");
        System.out.println(index);
        System.out.println("abcdabcd".indexOf("abcd"));
        System.out.println("abcdabcd".lastIndexOf("abcd"));
    }
}
