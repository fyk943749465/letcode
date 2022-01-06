package letcode.code400;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Question383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> rmap = new HashMap<>();
        Map<Character, Integer> mmap = new HashMap<>();

        for (int i = 0; i < ransomNote.length(); ++i) {
            Integer value = rmap.get(ransomNote.charAt(i));
            if (value == null) {
                rmap.put(ransomNote.charAt(i), 1);
            } else {
                value ++;
                rmap.put(ransomNote.charAt(i), value);
            }
        }

        for (int i = 0; i < magazine.length(); ++i) {
            Integer value = mmap.get(magazine.charAt(i));
            if (value == null) {
                mmap.put(magazine.charAt(i), 1);
            } else {
                value ++;
                mmap.put(magazine.charAt(i), value);
            }
        }

        Iterator<Character> iterator = rmap.keySet().iterator();
        while (iterator.hasNext()) {
            Character c = iterator.next();
            Integer rcnt = rmap.get(c);
            Integer mcnt = mmap.get(c);
            if (rcnt == null || mcnt == null) {
                return false;
            }
            if (rcnt.intValue() > mcnt.intValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        Question383 question383 = new Question383();
        System.out.println(question383.canConstruct(ransomNote, magazine));
    }
}
