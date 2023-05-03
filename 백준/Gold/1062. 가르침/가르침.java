import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static int N, K, ans;
    static boolean [] visited;
    static String [] words;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        }

        words = new String[N];

        for (int i = 0 ; i < N ; i++) {
            words[i] = br.readLine();
        }

        // a n t i c 은 반드시 가르쳐야 함
        int check = (1 << 0);
        check = check | (1 << 2);
        check = check | (1 << 8);
        check = check | (1 << 13);
        check = check | (1 << 19);

        visited = new boolean[1 << 26];
        visited[check] = true;

        dfs(0, 5, check);

        System.out.println(ans);
    }

    static void dfs(int idx, int cnt, int check) {
        if (cnt == K) {
            int temp = 0;
            for (int i = 0 ; i < N ; i++) {
                boolean flag = true;
                for (int j = 0 ; j < words[i].length() ; j++) {
                    int now = words[i].charAt(j) - 'a';
                    if ((check | (1 << now)) != check) {
                        flag = false;
                        break;
                    }
                }
                if (flag) temp++;
            }
            ans = Math.max(ans, temp);
            return;
        }

        for (int i = idx ; i < 26 ; i++) {
            int next = check | (1 << i);

            if (visited[next]) continue;

            visited[next] = true;
            dfs(i, cnt + 1, next);
        }
    }
}