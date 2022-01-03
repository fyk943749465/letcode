package letcode.code100;

import java.util.Arrays;

public class Question34 {

    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                int pos1 = mid;
                int pos2 = mid;
                while (pos1 >= 0 && nums[pos1] == target) pos1 --;
                while (pos2 < nums.length && nums[pos2] == target) pos2++;
                return new int[]{pos1 + 1, pos2 - 1};
            }

            if (left >= right) {
                return new int[]{-1, -1};
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }


        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {

        int nums[] = {1,4};
        int target = 4;

        Question34 question34 = new Question34();
        System.out.println(Arrays.toString(question34.searchRange(nums, target)));
    }
}