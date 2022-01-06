package letcode.code200;

public class Question142 {
    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;

            if (fast == slow) {
                break;
            }
        }

        if (fast == null) {
            return null;
        }

        ListNode start = head;
        while (start!=null && slow != null) {
            if (start == slow) {
                break;
            }
            start = start.next;
            slow = slow.next;
        }
        return start;
    }

    public static void main(String[] args) {

    }
}
