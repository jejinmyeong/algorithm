package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_boj_11444_피보나치수6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long [][] matrix = {{1, 1}, {1, 0}};

        long N = Long.parseLong(br.readLine());

        System.out.println(pow(matrix, N - 1)[0][0]);
    }

    static long [][] pow (long [][] matrix, long exp) {
        if (exp == 1 || exp == 0) return matrix;

        long [][] res = pow(matrix, exp / 2);

        res = multiply(res, res);

        if (exp % 2 == 1L) res = multiply(res, new long [][] {{1, 1},{1, 0}});

        return res;
    }

    static long [][] multiply (long [][] m1, long [][] m2) {
        long [][] res = new long[2][2];

        for (int k = 0 ; k < 2 ; k++) {
            for (int i = 0 ; i < 2 ; i++) {
                for (int j = 0 ; j < 2 ; j++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                    res[i][j] %= 1_000_000_007;
                }
            }
        }

        return res;
    }
}
