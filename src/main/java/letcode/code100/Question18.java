package letcode.code100;

import java.util.*;

public class Question18 {

    private int num1;
    private int num2;
    private int num3;
    private int num4;

    public Question18() {
    }

    public Question18(int num1, int num2, int num3, int num4){
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question18 that = (Question18) o;
        return num1 == that.num1 && num2 == that.num2 && num3 == that.num3 && num4 == that.num4;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num1, num2, num3, num4);
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }

        Set<Question18> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            int threeSum = target - nums[i];
            for (int j = i + 1; j < nums.length; ++j) {
                int twoSum = threeSum - nums[j];
                Map<Integer, Integer> map = new HashMap<>();
                for (int k = j + 1; k < nums.length; ++k) {
                    if (map.containsKey(twoSum - nums[k])) {
                        List<Integer> curList = new ArrayList<>();
                        curList.add(nums[i]);
                        curList.add(nums[j]);
                        curList.add(nums[k]);
                        curList.add(twoSum - nums[k]);
                        Collections.sort(curList);
                        Question18 question18 = new Question18(curList.get(0), curList.get(1), curList.get(2), curList.get(3));
                        if (!set.contains(question18)) {
                            res.add(curList);
                            set.add(question18);
                        }
                    } else {
                        map.put(nums[k], k);
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        Question18 question18 = new Question18();
        List<List<Integer>> lists = question18.fourSum(nums, 0);
        System.out.println(Arrays.toString(lists.toArray()));
    }
}
