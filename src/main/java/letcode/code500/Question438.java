package letcode.code500;

import java.util.*;

public class Question438 {


    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> index = new ArrayList<>();
        if (p.length() > s.length()) {
            return index;
        }
        int start = 0;
        int end = p.length();
        String substr = s.substring(start, end);

        Map<Character, Integer> mapp = new HashMap<>();
        Map<Character, Integer> maps = new HashMap<>();

        for (int i = 0; i < substr.length(); ++i) {
            Integer scnt = maps.get(s.charAt(i));
            if (scnt == null) {
                maps.put(s.charAt(i), 1);
            } else {
                scnt ++;
                maps.put(s.charAt(i), scnt);
            }

            Integer pcnt = mapp.get(p.charAt(i));
            if (pcnt == null) {
                mapp.put(p.charAt(i), 1);
            } else {
                pcnt ++;
                mapp.put(p.charAt(i), pcnt);
            }
        }

        while (end <= s.length()) {
            boolean flag = true;
            Iterator<Character> iterator = maps.keySet().iterator();
            while (iterator.hasNext()) {
                Character character = iterator.next();
                Integer pcnt = mapp.get(character);
                Integer scnt = maps.get(character);
                if (pcnt == null || scnt == null) {
                    flag = false;
                    break;
                }
                if (pcnt.intValue() != scnt.intValue()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                index.add(start);
            }

            Integer integer = maps.get(s.charAt(start));
            if (integer.intValue() == 1) {
                maps.remove(s.charAt(start));
            } else {
                integer --;
                maps.put(s.charAt(start), integer);
            }

            if (end == s.length()) {
                break;
            }

            Integer integer1 = maps.get(s.charAt(end));
            if (integer1 == null) {
                maps.put(s.charAt(end), 1);
            } else {
                integer1 ++;
                maps.put(s.charAt(end), integer1);
            }

            start++;
            end++;
        }

        return index;
    }


    public static void main(String[] args) {

        String s = "abab";
        String p = "ab";
        Question438 question438 = new Question438();
        System.out.println(Arrays.toString(question438.findAnagrams(s, p).toArray()));
    }
}
