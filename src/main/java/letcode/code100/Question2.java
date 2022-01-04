package letcode.code100;

public class Question2 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        int add = 0;  // jinwei
        ListNode p = null;
        ListNode newList = null;
        while (p1 != null && p2 != null) {
            int ans = p1.val + p2.val + add;
            add = ans / 10;
            if (p == null) {
                p = new ListNode(ans%10);
                newList = p;
            } else {
                p.next = new ListNode(ans%10);
                p = p.next;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == null && p2 == null ) {
            if (add != 0) {
                p.next = new ListNode(add);
            }
        } else {
            while (p1 != null) {
                int ans = p1.val + add;
                add = ans / 10;
                p.next = new ListNode(ans%10);
                p = p.next;
                p1 = p1.next;
            }
            while (p2 != null) {
                int ans = p2.val + add;
                add = ans / 10;
                p.next = new ListNode(ans%10);
                p = p.next;
                p2 = p2.next;
            }

            if (add != 0) {
                p.next = new ListNode(1);
            }
        }
        return newList;
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
        Question2 question2 = new Question2();

        Question2.ListNode listNode1 = question2.new ListNode(9);
        Question2.ListNode listNode2 = question2.new ListNode(9);
        Question2.ListNode listNode3 = question2.new ListNode(9);
        Question2.ListNode listNode4 = question2.new ListNode(9);
        Question2.ListNode listNode5 = question2.new ListNode(9);
        Question2.ListNode listNode6 = question2.new ListNode(9);
        Question2.ListNode listNode7 = question2.new ListNode(9);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        Question2.ListNode listNode11 = question2.new ListNode(9);
        Question2.ListNode listNode22 = question2.new ListNode(9);
        Question2.ListNode listNode33 = question2.new ListNode(9);
        Question2.ListNode listNode44 = question2.new ListNode(9);

        listNode11.next = listNode22;
        listNode22.next = listNode33;
        listNode33.next = listNode44;

        ListNode head = question2.addTwoNumbers(listNode1, listNode11);
        question2.print(head);

    }
}


