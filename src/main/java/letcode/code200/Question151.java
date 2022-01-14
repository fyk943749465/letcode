package letcode.code200;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Question151 {

    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" +");
        StringBuffer sb = new StringBuffer();
        for (int i = s1.length - 1; i >=0; --i) {
            if (i != s1.length-1) {
                sb.append(' ');
            }
            sb.append(s1[i]);
        }
        return sb.toString();
    }

    public String reverseWords2(String s) {
        String[] s1 = s.trim().split(" +");
        Collections.reverse(Arrays.asList(s1));
        return String.join(" ", s1);
    }

    public static void main(String[] args) {

        // String s = "the sky is blue";
        String s = "a good   example";
        // String s = " hello world ";
        Question151 question151 = new Question151();
        String s1 = question151.reverseWords2(s);
        System.out.println(s1);
    }
}
