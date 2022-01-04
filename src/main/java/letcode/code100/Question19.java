package letcode.code100;

public class Question19 {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return head;
        }
        ListNode p = head;
        int cnt = 0;
        while (p!=null) {
            cnt++;
            p = p.next;
        }

        int t = cnt - n + 1;
        if (t <= 0) {
            return null;
        }
        ListNode pre = null;
        p = head;
        cnt = 0;
        while (p != null) {
            cnt ++;
            if (cnt == t) {
                if (pre == null) {
                    p = p.next;
                    return p;
                }
                pre.next = p.next;
                break;
            }
            pre = p;
            p = p.next;
        }
        return head;
    }

    public void print(ListNode head) {

        ListNode p = head;
        while (p != null) {
            System.out.printf(p.val + " ");
            p = p.next;
        }
        System.out.println("\n-------------");
    }

    public static void main(String[] args) {
        Question19 question19 = new Question19();


        Question19.ListNode listNode = question19.new ListNode(1);
        Question19.ListNode listNode2 = question19.new ListNode(2);
        Question19.ListNode listNode3 = question19.new ListNode(3);
        Question19.ListNode listNode4 = question19.new ListNode(4);
        Question19.ListNode listNode5 = question19.new ListNode(5);
        Question19.ListNode listNode6 = question19.new ListNode(6);

        listNode.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;

        question19.print(listNode);

        ListNode head = question19.removeNthFromEnd(listNode, 1);

        question19.print(head);
    }
}
