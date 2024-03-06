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

            int [] temp = new int[2];

            temp[0] = arr[0];
            temp[1] = arr[1];

            int ans = temp[0] - temp[1];

            for (int i = 2 ; i < N ; i++) {
                int now = arr[i];

                if (temp[0] - now > temp[1] - now) {
                    ans = Math.max(ans, temp[0] - now);
                    temp[0] = now;
                } else {
                    ans = Math.max(ans, temp[1] - now);
                    temp[1] = now;
                }

                ans = Math.max(ans, Math.abs(temp[0] - temp[1]));
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}