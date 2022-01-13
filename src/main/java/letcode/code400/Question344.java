package letcode.code400;

public class Question344 {

    public void reverseString(char[] s) {

        for (int i = 0; i < s.length/2; ++i) {
            char tmp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = tmp;
        }
    }


    public static void main(String[] args) {

        char[] s = {'H','a','n','n','a', 'h'};
        Question344 question344 = new Question344();
        question344.reverseString(s);
    }
}
