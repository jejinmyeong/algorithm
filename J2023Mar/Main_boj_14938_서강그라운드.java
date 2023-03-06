package J2023Mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_14938_서강그라운드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int [] items = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= N ; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int [][] dist = new int[N + 1][N + 1];

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                if (i == j) continue;;
                dist[i][j] = 1_000_000_000;
            }
        }

        for (int i = 0 ; i < R ; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            dist[u][v] = l;
            dist[v][u] = l;
        }

        for (int k = 1 ; k <= N ; k++) {
            for (int i = 1 ; i <= N ; i++) {
                for (int j = 1 ; j <= N ; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int ans = 0;

        for (int i = 1 ; i <= N ; i++) {
            int temp = 0;
            for (int j = 1 ; j <= N ; j++) {
                if (dist[i][j] > M) continue;
                temp += items[j];
            }
            ans = Math.max(ans, temp);
        }

        System.out.println(ans);
    }
}
