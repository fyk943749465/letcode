package letcode.code300;

public class Question203 {

    public ListNode addElement(ListNode head, int t) {
        if (head == null) {
            head = new ListNode(t);
            return head;
        }
        if (head !=null) {
            ListNode node = new ListNode(t);
            ListNode p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
        }
        return head;
    }

    public void print(ListNode head) {
        ListNode p = head;
        while (p!= null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }
        if (head.val == val  && head.next == null) {
            return null;
        }
        if (head.val != val  && head.next == null) {
            return head;
        }
        while (head != null) {
            if (head.val != val) {
                break;
            }
            head = head.next;
        }
        if (head != null) {
            ListNode p1 = head;
            ListNode p2 = head.next;
            while (p2 != null) {
                if (p2.val == val) {
                    p1.next = p2.next;
                } else {
                    p1 = p2;
                }
                p2 = p2.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {

        ListNode head = null;
        Question203 question203 = new Question203();
        head = question203.addElement(head, 7);
        head = question203.addElement(head, 7);
        head = question203.addElement(head, 7);
        head = question203.addElement(head, 7);
        head = question203.addElement(head, 7);

        question203.print(head);

        head = question203.removeElements(head, 7);

        question203.print(head);
    }



    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}

