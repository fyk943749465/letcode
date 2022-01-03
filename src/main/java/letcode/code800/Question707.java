package letcode.code800;

/**
 * Question 707
 */
public class Question707 {

    public Node head;
    public Question707() {
    }

    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        Node p = head;
        int cnt = 0;
        while (p!= null) {
            if (cnt == index) {
                break;
            }
            p = p.next;
            cnt ++;
        }
        if (p!= null) {
            return p.val;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            Node p = head;
            head = node;
            node.next = p;
        }
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
        }

    }

    public void addAtIndex(int index, int val) {

        if (index <= 0) {
            addAtHead(val);
            return;
        }

        if (head == null) {
            return;
        }

        int cnt = 1;
        Node pre = head;
        Node p = head.next;
        while (p!=null) {
            if (cnt == index) {
                break;
            }
            pre = pre.next;
            p = p.next;
            cnt ++;
        }
        Node node = new Node(val);
        if (cnt == index) {
            if (pre.next == null) {
                pre.next = node;
            } else {
                pre.next = node;
                node.next = p;
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            if (head != null) {
                head = head.next;
            }
            return;
        }
        if (head != null) {
            int cnt = 1;
            Node pre = head;
            Node p = head.next;
            while (p != null) {
                if (cnt == index) {
                    break;
                }
                pre = pre.next;
                p = p.next;
                cnt ++;
            }
            if (cnt == index && p != null) {
                pre.next = p.next;
            }
        }
    }

    class Node {

        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Question707 linkedList = new Question707();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1));            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));            //返回3

        System.out.println("hello");

    }


}
