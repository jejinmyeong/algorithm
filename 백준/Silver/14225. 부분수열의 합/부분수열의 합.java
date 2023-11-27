import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N;
    static int [] nums;
    static boolean [] seq, visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0 ; i < N ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sum += nums[i];
        }

        seq = new boolean[sum + 2];
        visited = new boolean[N];

        dfs(0, 0);

        for (int i = 1 ; i < sum + 2 ; i++) {
            if (!seq[i]) {
                System.out.println(i);
                return;
            }
        }
    }

    static void dfs(int idx, int now) {
        if (idx == N) {
            seq[now] = true;
        } else {
            dfs(idx + 1, now + nums[idx]);
            dfs(idx + 1, now);
        }
    }
}