package letcode.code100;

public class Question35 {
    public int searchInsert(int[] nums, int target) {

        if (target <= nums[0]) {
            return 0;
        }
        if (target > nums[nums.length-1]) {
            return nums.length;
        }
        if (target == nums[nums.length -1]) {
            return nums.length -1;
        }

        int left = 0;
        int right = nums.length -1;
        int mid = (left + right) / 2;
        while (left < right) {
            if (nums[mid] == target) {
                return  mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        if (nums[left] >= target) {
            return left;
        } else {
            return left + 1;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1,3};
        int target = 2;

        Question35 question35 = new Question35();
        System.out.println(question35.searchInsert(nums, target));
    }
}

