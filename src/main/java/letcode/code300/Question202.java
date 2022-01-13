package letcode.code300;

import java.util.HashMap;
import java.util.Map;

public class Question202 {

    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = n;
        if (ans == 1) {
            return true;
        }
        map.put(n, 1);

        int cnt = 0;
        while (true) {
            while (ans != 0) {
                int t = ans % 10;
                ans = ans / 10;
                cnt += t * t;
            }
            if (cnt == 1){
                return true;
            }
            if (map.get(cnt) != null) {
                return false;
            } else {
                map.put(cnt, 1);
            }
            ans =cnt;
            cnt = 0;
        }
    }


    public static void main(String[] args) {

        Question202 question202 = new Question202();
        System.out.println(question202.isHappy(2));
    }
}
