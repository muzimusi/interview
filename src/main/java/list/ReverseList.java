package list;

public class ReverseList {
    // 反转链表-递归版
    // cur X cur.next->...
    private ListNode reverseList_cur(ListNode list) {
        if (list == null || list.getNext() == null)
            return list;
        ListNode newHead = reverseList_cur(list.getNext());
        list.getNext().setNext(list);
        list.setNext(null);
        return newHead;
    }

    //递归
    // cur X cur.next->...
    public ListNode ReverseList_cur(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode next = head.next;
        cur.next = null;
        ListNode newHead = ReverseList_cur(next);
        next.next = cur;
        return newHead;
    }

    // 循环
    public ListNode reverseList_loop(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = head.next.next;
        pre.next = null;
        // ...<-pre X cur->next->...
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode list = ListUtil.generateList();
        ListUtil.showList(list);
        ListUtil.showList(reverseList.reverseList_cur(list));
    }
}
