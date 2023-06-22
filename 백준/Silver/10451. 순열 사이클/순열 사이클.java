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

            int [][] arr = new int[2][N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1 ; i <= N ; i++) {
                arr[0][i] = i;
                arr[1][i] = Integer.parseInt(st.nextToken());
            }

            boolean [] visited = new boolean[N + 1];

            int ans = 0;

            for (int i = 1 ; i <= N ; i++) {
                if (visited[i]) continue;

                boolean [] temp = new boolean[N + 1];

                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);

                boolean isCycle = false;
                while (!queue.isEmpty()) {
                    int now = queue.poll();

                    int next = arr[1][now];
                    if (temp[next]) {
                        isCycle = true;
                        ans++;
                        break;
                    }

                    temp[next] = true;
                    queue.offer(next);
                }

                if (!isCycle) continue;

                for (int j = 1 ; j <= N ; j++) {
                    visited[j] = visited[j] | temp[j];
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);


    }
}