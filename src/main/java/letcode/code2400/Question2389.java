package letcode.code2400;

/**
 * 面试题 02.07. 链表相交
 *
 *
 **/
public class Question2389 {

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p1 = headA;
        boolean find = false;
        while(p1 != null) {
            ListNode p2 = headB;
            boolean flag = false;
            while (p2 != null) {
                if (p1 == p2) {
                    flag = true;
                    break;
                }
                p2 = p2.next;
            }
            if (flag == true) {
                find = true;
                break;
            }
            p1 = p1.next;
        }
        if (find) {
            return p1;
        }
        return null;
    }


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        int lenA = 0;
        int lenB = 0;
        ListNode p1 = headA, p2 = headB;
        while (p1 != null) {
            lenA ++;
            p1 = p1.next;
        }
        while (p2 != null) {
            lenB ++;
            p2 = p2.next;
        }

        int dis = 0;
        if (lenA > lenB) {
            dis = lenA - lenB;
            p1 = headA;
            p2 = headB;
        } else {
            dis = lenB - lenA;
            p1 = headB;
            p2 = headA;
        }

        int cnt = 0;
        while (p1 != null) {
            if (cnt == dis) {
                break;
            }
            cnt ++;
            p1 = p1.next;
        }

        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {

    }
}
