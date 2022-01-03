package letcode.code100;

import java.util.Arrays;

/**
 * 双指针解法
 */
public class Question27 {

    public int removeElement(int[] nums, int val) {
        int j = nums.length -1;
        for (int i = 0; i <=j; i++) {
            if (nums[i] == val) {
                swap(nums, i--, j--);
            }
        }
        return j + 1;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

        int[] nums = {3,2,2,3};
        int value = 3;
        Question27 question27 = new Question27();

        System.out.println(question27.removeElement(nums, value));
        System.out.println(Arrays.toString(nums));
    }
}

