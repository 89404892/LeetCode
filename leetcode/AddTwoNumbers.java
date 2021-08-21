public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode listNode = result;
        int tmp = 0;
        while (true) {
            int a = 0, b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            int sum = a + b + tmp;
            listNode.val = sum % 10;
            tmp = sum > 9 ? 1 : 0;
            if (l1 == null && l2 == null && tmp == 0) {
                break;
            }
            listNode.next = new ListNode(0);
            listNode = listNode.next;
        }
        return result;
    }
}
