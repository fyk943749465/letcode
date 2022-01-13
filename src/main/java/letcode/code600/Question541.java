package letcode.code600;

public class Question541 {


    public String reverseStr(String s, int k) {
        char[] res = new char[s.length()];

        int segs = s.length() / k;

        int pos = 0;
        for (int i = 0; i <segs; ++i) {
            for (int j = 0; j < k; ++j) {
                if (i%2 == 0) {
                    res[pos] = s.charAt(i * k + (k - j - 1));
                } else {
                    res[pos] = s.charAt( i* k + j);
                }
                pos ++;
            }
        }
        if (segs%2 == 0) {
           for (int i = s.length()-1; i >= segs * k; i--) {
               res[pos++] = s.charAt(i);
           }
        } else {
            for (int i = segs * k; i < s.length(); ++i) {
                res[pos++] = s.charAt(i);
            }
        }
        return new String(res);
    }
    public static void main(String[] args) {

        String s = "12341234123";
        int k = 4;
        Question541 question541 = new Question541();
        String s1 = question541.reverseStr(s, k);
        System.out.println(s1);
    }
}
