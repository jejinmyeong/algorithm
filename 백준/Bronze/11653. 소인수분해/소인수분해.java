import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        if (N == 1) return;

        boolean [] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        ArrayList<Integer> prime = new ArrayList<>();

        for (int i = 2 ; i <= N ; i++) {
            if (isPrime[i]) prime.add(i);

            for (int j = i + i ; j <= N ; j += i) isPrime[j] = false;
        }

        while (N != 1) {
            for (int p : prime) {
                if (N % p == 0) {
                    sb.append(p).append("\n");
                    N /= p;
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}