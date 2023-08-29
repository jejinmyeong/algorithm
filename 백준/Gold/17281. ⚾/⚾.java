import java.util.*;
import java.io.*;

public class Main {
    static boolean [] visited;
    static int [] seq;
    static int [][] inning;
    static int N, ans, cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        inning = new int[N][9];
        visited = new boolean[9];
        seq = new int[9];

        visited[0] = true;
        seq[3] = 0;

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 9 ; j++) {
                inning[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(ans);
    }

    static void dfs(int idx) {
        if (idx == 3) {
            dfs(idx + 1);
            return;
        }

        if (idx == 9) {
            ans = Math.max(ans, solution());
            cnt++;
            return;
        }

        for (int i = 1 ; i < 9 ; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            seq[idx] = i;
            dfs(idx + 1);
            visited[i] = false;
        }
    }

    static int solution() {
        int score = 0, start = 0, out = 0, foward = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0 ; i < N ; i++) {
            queue.clear();
            while (out < 3) {
                int run = inning[i][seq[start]];

                if (run == 0) out++;
                else {
                    queue.offer(foward + 4);
                }

                foward += run;

                while (!queue.isEmpty() && queue.peek() <= foward) {
                    queue.poll();
                    score++;
                }
                start = (start + 1) % 9;
            }
            out = 0;
        }

        return score;
    }
}