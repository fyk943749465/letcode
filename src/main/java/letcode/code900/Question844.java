package letcode.code900;

import java.util.Stack;

public class Question844 {

    public boolean backspaceCompare(String s, String t) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push((int)s.charAt(i));
            }
        }
        for (int i = 0; i < t.length(); ++i) {
            if (t.charAt(i) == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else  {
                stack2.push((int)t.charAt(i));
            }
        }
        if (stack1.size() != stack2.size()) {
            return false;
        }
        for (int i = 0; i <stack1.size(); ++i) {
            if (stack1.get(i) != stack2.get(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        String s = "y#fo##f";
        String t = "y#f#o##f";
        Question844 question844 = new Question844();
        System.out.println(question844.backspaceCompare(s, t));
    }
}

