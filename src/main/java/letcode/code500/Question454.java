package letcode.code500;

import java.util.HashMap;
import java.util.Map;

public class Question454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; ++i) {
            for (int j = 0; j < nums2.length; ++j) {
                int sum = nums1[i] + nums2[j];
                Integer value = map.get(sum);
                if (value == null) {
                    map.put(sum, 1);
                } else {
                    value ++;
                    map.put(sum, value);
                }
            }
        }

        int cnt = 0;

        for (int i = 0; i < nums3.length; ++i) {
            for (int j = 0; j < nums4.length; ++j) {
                int key = 0 - (nums3[i] + nums4[j]);
                Integer value = map.get(key);
                if (value != null) {
                    cnt += value.intValue();
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        Question454 question454 = new Question454();
        int[] num1 = {1, 2};
        int[] num2 = {-2, -1};
        int[] num3 = {-1, 2};
        int[] num4 = {0, 2};
        int cnt = question454.fourSumCount(num1, num2, num3, num4);
        System.out.println(cnt);
    }
}
