package letcode.code500;

import java.util.HashMap;
import java.util.Map;

public class Question459 {

    public boolean repeatedSubstringPattern(String s) {

        int maxseg = s.length() /2 ;
        int seg = 1;
        while (seg <= maxseg) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i+= seg) {
                if (i + seg > s.length()) {
                    map.put(s.substring(i), 1);
                } else {
                    map.put(s.substring(i, i + seg), 1);
                }
                if (map.size()>1) {
                    break;
                }
            }
            seg ++;
            if (map.size() == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Question459 question459 = new Question459();
        boolean abab = question459.repeatedSubstringPattern("aabaaba");
        System.out.println(abab);
    }
}
