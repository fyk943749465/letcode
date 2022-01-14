package letcode.code2200;

public class Question2192 {

    public String replaceSpace(String s) {
         return s.replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        String s = "We are happy";
        Question2192 question2192 = new Question2192();
        String s1 = question2192.replaceSpace(s);
        System.out.println(s1);
    }
}
