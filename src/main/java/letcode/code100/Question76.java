package letcode.code100;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Question76 {

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        Map<Integer, Integer> sMap = new HashMap<>();
        Map<Integer, Integer> tMap = new HashMap<>();
        initMap(sMap, s);
        initMap(tMap, t);
        if (!isExists(sMap, tMap)) {
            return "";
        } else {
            if (s.length() == t.length()) {
                return s;
            }

            int i = 0, j = i + t.length();
            int flagi = i, flagj = j;
            int min = s.length() + 1;
            Map<Integer, Integer> targetMap = new HashMap<>();
            for (int k = 0; k < t.length(); ++k) {
                Integer sValue = targetMap.get((int)s.charAt(k));
                if (sValue == null) {
                    targetMap.put((int)s.charAt(k), 1);
                } else {
                    sValue++;
                    targetMap.put((int)s.charAt(k), sValue);
                }
            }

            while (i +  t.length() <= j && j <= s.length()) {

                if (!isExists(targetMap, tMap) && j < s.length()) {
                    Integer sValue = targetMap.get((int) s.charAt(j));
                    if (sValue == null) {
                        targetMap.put((int) s.charAt(j), 1);
                    } else {
                        sValue++;
                        targetMap.put((int) s.charAt(j), sValue);
                    }
                    j++;
                } else  {
                    if (isExists(targetMap, tMap)) {
                        if (min > j - i) {
                            min = j - i;
                            flagi = i;
                            flagj = j;
                        }
                        Integer sValue = targetMap.get((int) s.charAt(i));
                        if (sValue == 1) {
                            targetMap.remove((int) s.charAt(i));
                        } else {
                            targetMap.put((int) s.charAt(i), sValue - 1);
                        }
                    }
                    i++;
                }
            }
            return s.substring(flagi, flagj);
        }
    }

    public boolean isExists(Map<Integer, Integer> sMap, Map<Integer, Integer> tMap) {

        for (Map.Entry<Integer, Integer> entry : tMap.entrySet()) {
            Integer sValue = sMap.get(entry.getKey());
            if (sValue == null) {
                return false;
            } else if (sValue < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public void initMap(Map<Integer, Integer> map, String s) {
        for (int i = 0; i < s.length(); ++i) {
            Integer sValue = map.get((int)s.charAt(i));
            if (sValue == null) {
                map.put((int)s.charAt(i), 1);
            } else {
                sValue++;
                map.put((int)s.charAt(i), sValue);
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
        BufferedReader in = new BufferedReader(new FileReader("src/main/java/code100/question76s.txt"));
        String s = "";
        String str = "";
        while ((str = in.readLine()) != null) {
            s += str;
        }
        str = "";
        String t = "";
        BufferedReader tin = new BufferedReader(new FileReader("src/main/java/code100/question76t.txt"));
        while((str = tin.readLine()) != null) {
            t += str;
        }
        s = "aaaaabb";
        t = "aabab";
        Question76 question76 = new Question76();
        System.out.println(question76.minWindow(s, t));
    }
}

