import java.io.*;
import java.util.*;

public class Main {
    static boolean [] visited;
    static int [] arr;
    static ArrayList<Integer> ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        ans = new ArrayList<>();

        for (int i = 1 ; i <= N ; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(ans);

        sb.append(ans.size()).append("\n");

        for (int i : ans) {
            sb.append(i).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int idx, int start) {
        if (!visited[arr[idx]]) {
            visited[arr[idx]] = true;
            dfs(arr[idx], start);
            visited[arr[idx]] = false;
        }

        if (arr[idx] == start) ans.add(start);
    }
}
