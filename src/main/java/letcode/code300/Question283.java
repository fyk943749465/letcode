package letcode.code300;

public class Question283 {

    public void moveZeroes(int[] nums) {

        int ans = 0;
        for (int i =0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[ans++] = nums[i];
            }
        }
        for (int j = ans; j< nums.length; ++j) {
            nums[j] = 0;
        }
    }


    public static void main(String[] args) {

        int[] nums = {0,1,0,3,12};

        Question283 question283 = new Question283();
        question283.moveZeroes(nums);
    }
}
