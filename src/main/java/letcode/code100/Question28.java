package letcode.code100;

public class Question28 {

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr2(String haystack, String needle) {

        if (needle== null || "".equals(needle)) {
            return 0;
        }
        boolean find = false;
        int pos = 0;
        int start = 0;
        for (int i = 0; i < haystack.length(); ++i) {
            if (haystack.charAt(i) == needle.charAt(pos)) {
                pos ++;
                if (pos == needle.length()) {
                    start = i - needle.length() + 1;
                    find = true;
                    break;
                }
            } else {
                i = i - pos;
                pos = 0;
            }
        }
        if (find) {
            return start;
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {

        String s = "mississippi";
        String p = "issip";
        Question28 question28 = new Question28();
        System.out.println(question28.strStr2(s, p));
    }
}
