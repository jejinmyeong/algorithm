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

            int [] arr = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1 ; i <= N ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            boolean [] visited = new boolean[N + 1];

            int ans = 0;

            for (int i = 1 ; i <= N ; i++) {
                if (visited[i]) continue;

                visited[i] = true;
                int now = arr[i];
                while (true) {
                    if (visited[now]) {
                        ans++;
                        break;
                    }
                    visited[now] = true;
                    now = arr[now];
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);


    }
}