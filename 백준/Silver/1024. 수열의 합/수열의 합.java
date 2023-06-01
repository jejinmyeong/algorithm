import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        long sum = 0L;

        for (long i = 0 ; i < L ; i++) {
            sum += i;
        }

        if (sum > N) {
            System.out.println(-1);
            return;
        }

        long start = 0;
        long end = L - 1;

        long s = 0;
        long e = 0;

        while (true) {
            // 길이가 L보다 작은 경우
            if (end - start + 1 < L) {
                break;
            }

            if (sum == N) {
                s = start;
                e = end;
            }

            if (sum <= N) {
                sum += ++end;
            } else {
                sum -= start++;
            }
        }

        if (e - s + 1 > L && s == 0) {
            s++;
        }
        
        if (e - s + 1 < L || e - s + 1 > 100) {
            System.out.println(-1);
            return;
        }
        
        for (long i = s ; i <= e ; i++) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);

    }
}
