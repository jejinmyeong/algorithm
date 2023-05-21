import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    static int N;
    static boolean [] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];

        dfs(0, "");

        System.out.print(sb);
    }

    static void dfs (int k, String temp) {
        if (k == N) {
            sb.append(temp).append("\n");
            return;
        }

        for (int i = 1 ; i <= N ; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(k + 1, temp + i + " ");
            visited[i] = false;
        }
    }


}
