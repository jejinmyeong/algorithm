import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            Integer [] arr = new Integer[N];

            for (int i = 0 ; i < N ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, Collections.reverseOrder());

            int left = arr[0];
            int right = arr[1];

            int ans = left-right;

            for (int i = 2 ; i < N ; i++) {
                int now = arr[i];

                if (left - now > right - now) {
                    ans = Math.max(ans, left - now);
                    left = now;
                } else {
                    ans = Math.max(ans, right - now);
                    right = now;
                }

                ans = Math.max(ans, Math.abs(left - right));
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}