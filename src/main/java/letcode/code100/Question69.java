package letcode.code100;

public class Question69 {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int mid = x / 2;
        while (mid >= 46340 || mid * mid > x) {
            mid = mid / 2;
        }
        int  ans = 0;
        for (int i = mid;  i<= 46340; i++) {
            if (i * i > x){
                ans = i - 1;
                break;
            } else {
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        Question69 question69 = new Question69();
        System.out.println(question69.mySqrt(2147395600));
    }
}

