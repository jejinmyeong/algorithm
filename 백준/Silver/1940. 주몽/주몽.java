import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        boolean [] visited = new boolean[100001];

        int ans = 0;

        for (int i = 0 ; i < N ; i++) {
            int now = Integer.parseInt(st.nextToken());

            if (M - now > 100000 || M - now < 0) continue;
            if (visited[M - now]) {
                ans++;
                visited[M - now] = false;
            } else {
                visited[now] = true;
            }
        }

        System.out.println(ans);
    }
}