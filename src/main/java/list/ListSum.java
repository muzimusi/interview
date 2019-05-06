package list;


public class ListSum {
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        int carry = 0;
        int value = 0;
        // 链表相加，null节点按值为0考虑
        while (list1 != null || list2 != null) {
            int a = list1 == null ? 0 : list1.getVal();
            int b = list2 == null ? 0 : list2.getVal();
            value = a + b + carry;
            if (value >= 10) {
                value %= 10;
                carry = 1;
            } else carry = 0;

            // 计算值
            cur.setNext(new ListNode(value));
            cur = cur.getNext();
            list1 = list1 != null ? list1.getNext() : null;
            list2 = list2 != null ? list2.getNext() : null;
        }
        // 扩展节点进位
        if (carry == 1)
            cur.setNext(new ListNode(1));
        return head.getNext();
    }

    // 反转链表
    private ListNode reverseList(ListNode list) {
        if (list == null || list.getNext() == null)
            return list;
        ListNode newHead = reverseList(list.getNext());
        list.getNext().setNext(list);
        list.setNext(null);
        return newHead;
    }

    public static void main(String[] args) {
        // (2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode alist1 = new ListNode(2);
        ListNode alist2 = new ListNode(4);
        ListNode alist3 = new ListNode(3);
        ListNode alist4 = new ListNode(7);
        alist1.setNext(alist2);
        alist2.setNext(alist3);
        alist3.setNext(alist4);
        ListNode blist1 = new ListNode(5);
        ListNode blist2 = new ListNode(6);
        ListNode blist3 = new ListNode(6);
        blist1.setNext(blist2);
        blist2.setNext(blist3);
        ListSum listSum = new ListSum();

        ListUtil.showList(alist1);
//        ListUtil.showList(listSum.reverseList(alist1));
        ListUtil.showList(blist1);
//        ListUtil.showList(listSum.reverseList(blist1));

        ListNode resList = listSum.addTwoNumbers(alist1, blist1);
        ListUtil.showList(resList);

    }
}
