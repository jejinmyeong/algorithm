import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            long [] arr = new long[N];

            for (int i = 0 ; i < N ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long ans = 0;
            long max = 0;
            for (int i = N - 1 ; i >= 0 ; i--) {
                if (arr[i] > max) max = arr[i];
                else ans += max - arr[i];
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}