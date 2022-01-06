package letcode.code400;

import java.util.*;

public class Question349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums1.length; ++i) {
            Integer value = map.get(nums1[i]);
            if(value == null) {
                map.put(nums1[i], 1);
            }
        }


        for (int i = 0; i < nums2.length; ++i) {
            Integer integer = map.get(nums2[i]);
            if (integer != null) {
                set.add(nums2[i]);
            }
        }
        int[] ans = new int[set.size()];
        int i = 0;
        for(int key : set) {
            ans[i++] = key;
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] s = {4, 9, 5};
        int[] t = {9, 4, 9, 8, 4};
        Question349 question349 = new Question349();
        System.out.println(Arrays.toString(question349.intersection(s, t)));
    }
}
