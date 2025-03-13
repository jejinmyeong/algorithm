import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int [] stores = new int[n];

            for (int i = 0; i < n; i++) {
                stores[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(stores);

            int ans = 0;

            for (int i = 1 ; i < n ; i++) {
                ans += stores[i] - stores[i - 1];
            }

            ans += stores[n - 1] - stores[0];

            sb.append(ans).append("\n");
        }

        System.out.println(sb);

    }
}

