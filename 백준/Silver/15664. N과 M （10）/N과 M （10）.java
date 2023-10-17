import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int [] arr;
    static boolean [] visited;
    static StringBuffer sb;
    static HashSet<String> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuffer();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        set = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backTracking(0, 0, "");

        System.out.print(sb);
    }

    static void backTracking(int idx, int start, String now) {
        if (idx == M) {
            sb.append(now).append("\n");
            return;
        }

        for (int i = start ; i < N ; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            String next = now + arr[i] + " ";
            if (!set.contains(next)) {
                set.add(next);
                backTracking(idx + 1, i + 1, next);
            }
            visited[i] = false;
        }
    }
}