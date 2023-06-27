import java.util.*;
import java.io.*;
import java.math.*;
import java.util.stream.Collectors;

public class Main {
    static int N, M;
    static int [] arr;
    static StringBuffer sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuffer();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, new StringBuffer());

        System.out.print(sb);

    }

    static void dfs(int cnt, StringBuffer temp) {
        if (cnt == M) {
            sb.append(temp).append("\n");
            return;
        }

        for (int i = 0 ; i < N ; i++) {
            dfs(cnt + 1, new StringBuffer(temp).append(arr[i]).append(" "));
        }
    }
}