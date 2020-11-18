package list;

/**
 * leetcode 2 M
 * *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * *
 * 示例：
 * *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);
        l11.setNext(l12);
        l12.setNext(l13);
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.setNext(l22);
        l22.setNext(l23);
        AddTwoNumbers instance = new AddTwoNumbers();
        ListNode sumList = instance.addTwoNumbers2(l11, l21);
        ListUtil.showList(l11);
        ListUtil.showList(l21);
        ListUtil.showList(sumList);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        boolean carry = false;
        ListNode sumListHead = null;
        ListNode sumListTail = null;
        int sumTmp = 0;
        while (l1 != null || l2 != null) {
            // 补0对齐位数
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            // 补0对齐位数
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            sumTmp = l1.val + l2.val;
            if (carry) {
                sumTmp++;
            }
            if (sumTmp < 10) {
                carry = false;
            } else {
                carry = true;
                sumTmp -= 10;
            }
            ListNode node = new ListNode(sumTmp);
            if (sumListHead == null) {
                sumListHead = node;
                sumListTail = node;
            } else {
                sumListTail.next = node;
                sumListTail = node;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (carry) {
            ListNode node = new ListNode(1);
            sumListTail.next = node;
            sumListTail = node;
        }

        return sumListHead;
    }

    //优化上述代码
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0;
        ListNode sumListHead = null;
        ListNode sumListTail = null;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = carry + x + y;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            if (sumListHead == null) {
                sumListHead = node;
            } else {
                sumListTail.next = node;
            }
            sumListTail = node;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry > 0) {
            sumListTail.next = new ListNode(carry);
        }

        return sumListHead;
    }
}
