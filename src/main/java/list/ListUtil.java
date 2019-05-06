package list;

public class ListUtil {

    public static void showList(ListNode list) {
        while (list != null) {
            if (list.getNext() == null)
                System.out.print(list.val);
            else
                System.out.print(list.val + "->");
            list = list.getNext();
        }
        System.out.println();
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
}
