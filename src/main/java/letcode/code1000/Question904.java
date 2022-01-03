package letcode.code1000;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Question904 {

    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> map = new LinkedHashMap<>();
        int max = 0;
        int k = 0;
        for (int i = 0; i < fruits.length; ++i) {

            Integer cn = map.get(fruits[i]);
            if (cn != null) {
                cn ++;
                map.put(fruits[i], cn);
            } else {
                map.put(fruits[i], 1);
            }
            if (map.size() > 2) {
                // 第i元素是刚加入的元素，也是map第三个元素
                // 对　i 之前的所有元素进行检测，
                for (int j = k; j < i; ++j) {
                    Integer integer = map.get(fruits[j]);
                    // 之前map中删除的元素，再次取得时，要判空
                    if (integer == null) {
                        continue;
                    }
                    if (integer != 1) { //如果不等于1,表示在[j,i-1]区间出现不止１次
                        map.put(fruits[j], integer -1);
                    }
                    //如果等于1,表示在[j,i-1]区间出现了１次，这个元素可以删除了，为了保证map中只有两个元素
                    if (integer == 1) {
                        map.remove(fruits[j]);
                        k = j + 1;
                        break;
                    }
                }
            }
            max = mapSum(map, max);
        }
        return max;
    }

    public int mapSum(Map<Integer, Integer> map, int max) {
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next().getValue();
        }
        if (max < sum) {
            max = sum;
        }
        return max;
    }

    public static void main(String[] args) {

        int[] fruits ={0,5,9,0,9,9,0,0,2,7};
        Question904 question904 = new Question904();
        System.out.println(question904.totalFruit(fruits));
    }
}
