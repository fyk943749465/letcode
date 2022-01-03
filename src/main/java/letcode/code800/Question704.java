package letcode.code800;

public class Question704 {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1 ;

        int mid = (left + right) / 2;
        while (true) {
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            if (left == mid || mid == right) {
                return -1;
            }
            if (target < nums[mid]) {
                right = mid - 1;
                mid = (left + right) / 2;
            } else {
                left = mid + 1;
                mid = (left + right) / 2;
            }
        }
    }

    public static void main(String[] args) {

        int nums[] = {2, 5};

        Question704 question704 = new Question704();
        System.out.println(question704.search(nums, 5));
    }
}