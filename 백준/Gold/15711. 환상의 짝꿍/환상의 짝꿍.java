import java.io.*;
import java.util.*;

public class Main {
    static boolean [] isPrimeNumber;
    static ArrayList<Integer> primes;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        isPrimeNumber = new boolean[2_000_001];
        primes = new ArrayList<>();

        Arrays.fill(isPrimeNumber, true);

        isPrimeNumber[0] = isPrimeNumber[1] = false;

        for (int i = 2 ; i <= 2_000_000 ; i++) {
            if (isPrimeNumber[i]) primes.add(i);
            for (int j = i * 2 ; j <= 2_000_000 ; j += i) {
                isPrimeNumber[j] = false;
            }
        }

        for (int t = 1 ; t <= T ; t++) {
            st = new StringTokenizer(br.readLine());

            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            long sum = A + B;

            if (sum < 4) sb.append("NO").append("\n");
            else if (sum % 2 == 0) {
                sb.append("YES").append("\n");
            } else {
                if (isPrime(sum - 2)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }

        System.out.print(sb);
    }

    static boolean isPrime (long num) {
        if (num <= 2_000_000) return isPrimeNumber[(int) num];

        for (int i = 0 ; i < primes.size() ; i++) {
            if (num % primes.get(i) == 0) return false;
        }
        
        return true;
    }
}
