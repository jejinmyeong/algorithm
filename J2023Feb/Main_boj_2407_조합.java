package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_boj_2407_조합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int max = Math.max(M, N - M);
        int min = Math.min(M, N - M);

        BigInteger top = BigInteger.valueOf(1);
        for (int i = max + 1 ; i <= N ; i++) {
            top = top.multiply(BigInteger.valueOf(i));
        }

        BigInteger bottom = BigInteger.valueOf(1);
        for (int i = 2 ; i <= min ; i++) {
            bottom = bottom.multiply(BigInteger.valueOf(i));
        }

        System.out.println(top.divide(bottom));

    }
}
