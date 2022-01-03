package letcode.code300;

public class Question206 {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode reverseList(ListNode head) {

        if (head == null) {
             return null;
        }
        ListNode pre = null;
        while (head != null) {
            if (pre == null) {
                pre = head;
                head = head.next;
                pre.next = null;
            } else {
                ListNode cur = head.next;
                head.next = pre;
                pre = head;
                head = cur;
            }
        }
        return pre;
    }

    public void print(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
        System.out.println("----------------------------------------");
    }



    public static void main(String[] args) {
        Question206 question206 = new Question206();
        Question206.ListNode listNode = question206.new ListNode(1);
        Question206.ListNode listNode2 = question206.new ListNode(2);


        listNode.next = listNode2;

        question206.print(listNode);

        ListNode head = question206.reverseList(listNode);

        question206.print(head);

    }
}
