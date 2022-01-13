package letcode.code100;

import java.util.*;

public class Question15 {

    private int num1;
    private int num2;
    private int num3;

    public Question15() {

    }

    public Question15(int num1, int num2, int num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question15 that = (Question15) o;
        return num1 == that.num1 && num2 == that.num2 && num3 == that.num3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num1, num2, num3);
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Set<Question15> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            int twoSum = 0 - nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; ++j) {
                if (map.containsKey(twoSum - nums[j])) {  // a + b + c = 0; a is nums[i], b is nums[j], c is twoSum - nums[j]
                    List<Integer> curList = new ArrayList<>();
                    curList.add(nums[i]);
                    curList.add(nums[j]);
                    curList.add(twoSum - nums[j]);
                    Collections.sort(curList);
                    Question15 question15 = new Question15(curList.get(0), curList.get(1), curList.get(1));
                    if (!numSet.contains(question15)) {
                        res.add(curList);
                        numSet.add(question15);
                    }
                } else {
                    map.put(nums[j], j);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, 4};
        Question15 question15 = new Question15();
        List<List<Integer>> lists = question15.threeSum(nums);
        System.out.println(Arrays.toString(lists.toArray()));
    }
}
