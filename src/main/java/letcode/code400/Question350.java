package letcode.code400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Question350 {

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> ans = new HashMap<>();

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < nums1.length; ++i) {
            Integer value = map1.get(nums1[i]);
            if (value == null) {
                map1.put(nums1[i], 1);
            } else {
                value ++;
                map1.put(nums1[i], value);
            }
        }

        for (int i = 0; i < nums2.length; ++i) {
            Integer value = map2.get(nums2[i]);
            if (value == null) {
                map2.put(nums2[i], 1);
            } else {
                value ++;
                map2.put(nums2[i], value);
            }
        }

        int cnt = 0;
        Iterator<Integer> iterator = map1.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            Integer value1 = map1.get(key);
            Integer value2 = map2.get(key);
            if (value1 == null || value2 == null) {
                continue;
            }
            int value = value1.intValue() > value2.intValue() ? value2.intValue() : value1.intValue();
            cnt += value;
            ans.put(key, value);
        }

        int[] result = new int[cnt];
        int i = 0;
        Iterator<Integer> iterator1 = ans.keySet().iterator();
        while (iterator1.hasNext()) {
            Integer key = iterator1.next();
            Integer value = ans.get(key);
            for (int t = 0; t < value; ++t) {
                result[i++] = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = {4, 5, 9};
        int[] num2 = {9, 4, 9, 8, 4};
        Question350 question350 = new Question350();
        System.out.println(Arrays.toString(question350.intersect(num1, num2)));
    }
}
