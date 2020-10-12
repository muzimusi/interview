package list;

public class RMRepeatNode {

    public static void main(String[] args) {
        ListNode repeatList = ListUtil.generateRepeatList();
        ListUtil.showList(repeatList);

//        ListNode insertList = repeatList.getNext();
//        repeatList.setNext(null);
//        ListNode noRepeatList = repeatList;
        // 传入第一个链表（也就是第一个节点）
//        ListNode resultList = removeRepeatNodeByOrderRecursion(noRepeatList, noRepeatList, insertList);
        ListNode resultList = removeRepeatNodeByOrderLoop(repeatList);
        ListUtil.showList(resultList);
    }

    // 如果前面列表中不含当前元素，则将当前节点追加到链表末尾
    // [firstnode,tailNode]表示无重复元素的链表
    private static ListNode removeRepeatNodeByOrderRecursion(ListNode firstNode, ListNode tailNode, ListNode node) {
        if (firstNode == null) {
            return null;
        }
        if (node == null)
            return firstNode;
        if (!isContains(firstNode, tailNode, node)) {

            ListNode tmp = new ListNode(node.getVal());
            tailNode.setNext(tmp);
            tailNode = tmp;
        }

        return removeRepeatNodeByOrderRecursion(firstNode, tailNode, node.getNext());
    }

    // 从链表头开始遍历，判断链表是否包含给定节点
    private static boolean isContains(ListNode list, ListNode tailNode, ListNode node) {
        while (list != null) {
            if (list.getVal() == node.getVal())
                return true;
            list = list.getNext();
        }
        tailNode = list;
        return false;
    }

    private static ListNode removeRepeatNodeByOrderLoop(ListNode list) {
        if (list == null || list.getNext() == null)
            return list;
        ListNode noRepeatHead = list;
        ListNode noRepeatTail = noRepeatHead;
        ListNode currentNode = list.getNext();
        // [noRepeatHead,noRepeatTail]为无重复链表，无需去重
        // [currentNode,...]为待处理链表
        boolean isRepeatNode = false;
        while (currentNode != null) {
            isRepeatNode = false;
            list = noRepeatHead;
            while (list != null) {
                if (list.getVal() == currentNode.getVal()) {
                    isRepeatNode = true;
                    break;
                }
                if (list.getVal() == noRepeatTail.getVal()) {
                    isRepeatNode = false;
                    break;
                }
                list = list.getNext();
            }
            if (!isRepeatNode) {
                noRepeatTail.setNext(currentNode);
                noRepeatTail = currentNode;
            }
            currentNode = currentNode.getNext();
        }
        list = noRepeatHead;
        while (list != null) {
            if (list.getVal() == noRepeatTail.getVal()) {
                noRepeatTail.setNext(null);
                break;
            }
            list = list.getNext();
        }
        return noRepeatHead;
    }
}
