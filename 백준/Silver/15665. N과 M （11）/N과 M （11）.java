import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static int N, M;
    static int [] arr;
    static StringBuffer sb;
    static HashSet<String> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb = new StringBuffer();
        set = new HashSet<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backTracking(0, "");

        System.out.print(sb);
    }

    static void backTracking(int idx, String now) {
        if (idx == M) {
            sb.append(now).append("\n");
            return;
        }

        for (int i = 0 ; i < N ; i++) {
            String next = now + arr[i] + " ";

            if (set.contains(next)) continue;
            else set.add(next);

            backTracking(idx + 1, next);
        }
    }
}
