package letcode.code1000;

import java.util.Arrays;

public class Question977 {

    public int[] sortedSquares(int[] nums) {

        int[] nums2 = new int[nums.length];
        int min = 100000;
        int key = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (Math.abs(nums[i]) < min) {
                min = Math.abs(nums[i]);
                key = i;
            }
        }

        int l = key - 1, r = key + 1;
        int p = 0;
        nums2[p++] = nums[key] * nums[key];
        while (l >= 0 && r < nums.length) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                nums2[p++] = nums[r] * nums[r];
                r ++;
            } else {
                nums2[p++] = nums[l] * nums[l];
                l --;
            }
        }
        if (l>=0) {
            while (l>=0) {
                nums2[p++] = nums[l] * nums[l];
                l--;
            }
        }
        if (r < nums.length) {
            while (r < nums.length) {
                nums2[p++] = nums[r] * nums[r];
                r++;
            }
        }
        return nums2;
    }

    public static void main(String[] args) {

        int[] nums = {-10000,-9999,-7,-5,0,0,10000};
        Question977 question977 = new Question977();
        System.out.println(Arrays.toString(question977.sortedSquares(nums)));
    }
}

