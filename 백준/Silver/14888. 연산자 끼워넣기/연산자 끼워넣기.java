import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    static int N, max, min;
    static int [] arr, operator;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[4];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < 4 ; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        dfs (1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int idx, int now) {
        if (idx == N) {
            max = Math.max(max, now);
            min = Math.min(min, now);
            return;
        }

        // 덧셈
        if (operator[0] != 0) {
            operator[0]--;
            dfs(idx + 1, now + arr[idx]);
            operator[0]++;
        }

        // 뻴셈
        if (operator[1] != 0) {
            operator[1]--;
            dfs(idx + 1, now - arr[idx]);
            operator[1]++;
        }

        // 곱셈
        if (operator[2] != 0) {
            operator[2]--;
            dfs(idx + 1, now * arr[idx]);
            operator[2]++;
        }

        // 나눗셈
        if (operator[3] != 0 && arr[idx] != 0) {
            operator[3]--;
            if (arr[idx] > 0) {
                dfs(idx + 1, now / arr[idx]);
            } else {
                dfs (idx + 1, -(now / -(arr[idx])));
            }
            operator[3]++;
        }
    }
}