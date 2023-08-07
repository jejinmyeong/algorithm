import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static ArrayList<Integer> primeNumber;
    static long max = 4_000_000_000L;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        boolean [] isPrime = new boolean[(int) Math.sqrt(max) + 2];

        primeNumber = new ArrayList<>();

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2 ; i <= Math.sqrt(max) + 1 ; i++) {
            if (isPrime[i]) primeNumber.add(i);
            for (int j = i + i ; j <= Math.sqrt(max) + 1 ; j += i) {
                isPrime[j] = false;
            }
        }

        while (T-- > 0) {
            long N = Long.parseLong(br.readLine());

            if (N == 0 || N == 1) sb.append(2).append("\n");
            else sb.append(solution(N)).append("\n");
        }

        System.out.print(sb);
    }
    static long solution(long N) {
        for (long i = N ; ; i++) {
            boolean isPrime = true;
            for (int p : primeNumber) {
                if (p > Math.sqrt(i)) break;
                if (i % p == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                return i;
            }
        }
    }
}