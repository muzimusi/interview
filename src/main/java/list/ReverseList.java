package list;

public class ReverseList {
    // 反转链表-递归版
    private ListNode reverseList_cur(ListNode list) {
        if (list == null || list.getNext() == null)
            return list;
        ListNode newHead = reverseList_cur(list.getNext());
        list.getNext().setNext(list);
        list.setNext(null);
        return newHead;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode list = ListUtil.generateList();
        ListUtil.showList(list);
        ListUtil.showList(reverseList.reverseList_cur(list));
    }
}
