import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int max = 10000000;

        boolean [] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2 ; i <= max ; i++) {
            for (int j = i * 2 ; j <= max ; j += i) {
                isPrime[j] = false;
            }
        }

        List<Long> list = new ArrayList<>();
        for (int i = 2 ; i <= max ; i++) {
            if (B <= i) break;
            if (isPrime[i]) {
                for (int j = 2 ; ; j++) {
                    long num = (long) Math.pow(i , j);
                    if (num > B) break;
                    if (num >= A) list.add(num);
                }
            }
        }

        System.out.println(list.size());
    }
}