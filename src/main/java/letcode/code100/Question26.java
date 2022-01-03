package letcode.code100;

import java.util.Arrays;

/**
 * 删除元素
 */
public class Question26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int ans = 1;
        for (int i =1; i < nums.length; ++i) {
            if (nums[i-1] != nums[i]) {
                nums[ans++] = nums[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {

        int[] nums = {1,1,2};
        Question26 question26 = new Question26();
        System.out.println(question26.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
