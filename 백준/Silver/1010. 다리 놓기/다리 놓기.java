import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        BigInteger [] factorial = new BigInteger[31];
        factorial[0] = new BigInteger("1");
        for (int i = 1 ; i <= 30 ; i++) {
            factorial[i] = factorial[i-1].multiply(new BigInteger(String.valueOf(i)));
        }

        for (int tc = 0 ; tc < T ; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(factorial[M].divide(factorial[M - N]).divide(factorial[N])).append("\n");
        }
        System.out.println(sb);
    }
}