package letcode.code100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question1 {

    
    public int[] twoSum(int[] nums, int target) {

        int[] num = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ans = target - nums[i];
            if (map.containsKey(ans)) {
                num[0] = map.get(ans);
                num[1] = i;
            }
            map.put(nums[i], i);
        }
        return num;
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 4};

        Question1 question1 = new Question1();
        System.out.println(Arrays.toString(question1.twoSum(nums, 6)));
    }
}
