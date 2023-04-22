import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        boolean [] isPrime = new boolean[10001];

        Arrays.fill(isPrime, true);

        for (int i = 2 ; i <= 100 ; i++) {
            for (int j = i + i ; j <= 10000 ; j += i) {
                isPrime[j] = false;
            }
        }

        for (int tc = 0 ; tc < T ; tc++) {
            int N = Integer.parseInt(br.readLine());

            int start = N / 2;
            while (start > 1) {
                if (isPrime[start] && isPrime[N - start]) {
                    sb.append(start + " " + (N - start)).append("\n");
                    break;
                }
                start--;
            }
        }

        System.out.print(sb);
    }
}