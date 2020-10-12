package list;

public class ListUtil {

    public static void showList(ListNode head) {
        while (head.next != null) {
            System.out.printf(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static ListNode generateList() {
        ListNode alist1 = new ListNode(2);
        ListNode alist2 = new ListNode(4);
        ListNode alist3 = new ListNode(3);
        ListNode alist4 = new ListNode(7);
        alist1.setNext(alist2);
        alist2.setNext(alist3);
        alist3.setNext(alist4);

        return alist1;
    }

    public static ListNode generateRepeatList() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l11 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l22 = new ListNode(2);
        l1.setNext(l2);
        l2.setNext(l11);
        l11.setNext(l3);
        l3.setNext(l4);
        l4.setNext(l22);

        return l1;
    }
}
