package letcode.code100;

public class Question24 {


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }

        ListNode p = head.next;
        ListNode pre = null;
        while (head != null && head.next != null) {

            ListNode tmp = head.next;
            head.next = tmp.next;
            tmp.next = head;
            if (pre == null) {
                pre = head;
            } else {
                pre.next = tmp;
                pre = head;
            }
            head = head.next;
        }
        return p;
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

        Question24 question24 = new Question24();

        ListNode listNode0 = question24.new ListNode();

        ListNode listNode = question24.new ListNode(1);
        ListNode listNode2 = question24.new ListNode(2);
        ListNode listNode3 = question24.new ListNode(3);
        ListNode listNode4 = question24.new ListNode(4);
        ListNode listNode5 = question24.new ListNode(5);
        ListNode listNode6 = question24.new ListNode(6);


//        listNode.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;

        question24.print(null);

        ListNode head = question24.swapPairs(null);

        question24.print(head);



    }
}
