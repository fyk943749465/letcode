package letcode.code300;

/**
 * 双指针法
 */
public class Question209 {

    public int minSubArrayLen(int target, int[] nums) {

        int i = 0, j = 0;
        int min = 10001;
        int sum = 0;
        boolean flag = true;
        while (i < nums.length && j < nums.length) {
            sum += nums[j];
            if (!flag) sum -= nums[j];
            if (sum >= target) {
                if (min > j - i + 1) {
                    min = j - i + 1;
                }
                sum -= nums[i];

                i++;
                flag = false;
            } else {
                flag = true;
                j++;
            }
        }
        while (i < nums.length) {
            if (sum >= target) {
                if (min > j - i ) {
                    min = j - i;
                }
                sum -= nums[i];
            }
            i ++;
        }
        return min == 10001 ? 0 : min;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        Question209 question209 = new Question209();
        System.out.println(question209.minSubArrayLen(11, nums));
    }
}
