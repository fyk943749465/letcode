package letcode.code100;

import java.util.Arrays;

public class Question59 {

    public int[][] generateMatrix(int n) {

        int arr[][] = new int[n][n];
        int t = 0;
        int cnt = 1;
        for (int i = 1; i <= 2*n -1; ++i) {
            if ( i % 4 == 1) {
                for (int j = 1; j <= n - t; ++j) {
                    arr[i/4][j-1 + i/4] = cnt++;
                }
            } else if (i % 4 == 2) {
                for (int j = 1; j <= n - t; ++j) {
                    arr[i/4 + j][n - i/4 - 1] = cnt++;
                }
            } else if (i % 4 == 3) {
                for (int j = 1; j <= n - t; ++j) {
                    arr[n - 1 - i/4][n- i/4- j-1] = cnt++;
                }
            } else {
                for (int j = 1; j <= n - t; ++j) {
                    arr[n-j-i/4][i/4 - 1] = cnt++;
                }
            }
            if (i%4 == 1 || i%4==3) {
                t++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        return arr;
    }

    public static void main(String[] args) {
        Question59 question59 = new Question59();
        question59.generateMatrix(20);
    }
}

