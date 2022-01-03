package letcode.code400;

public class Question367 {

    public boolean isPerfectSquare(int num) {

        if (num == 0 || num == 1) {
            return true;
        }
        for (int i = 2; i <= 46340; ++i) {
            if (i * i == num) {
                return true;
            }
            if (i * i > num) {
                return false;
            }
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        int i = num / 2;
        while (i > 46340 || i * i > num) {
            i = i / 2;
        }
        for (int j = i; j <= 46340; j++) {
            if (j * j == num) {
                return true;
            }
            if (j * j > num) {
                return false;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        Question367 question367 = new Question367();
        System.out.println(question367.isPerfectSquare2(2147483647));
    }
}