import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N, ans;
    static int [] left, right;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        left = new int[N];
        right = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            left[i] = Integer.parseInt(st1.nextToken());
            right[i] = Integer.parseInt(st2.nextToken());
        }

        bt(0, 0, 0);

        System.out.println(ans);

    }

    static void bt(int l, int r, int s) {
        if (l == N || r == N) {
            ans = Math.max(ans, s);
            return;
        }

        // 왼쪽만 버리는 경우
        bt(l + 1, r, s);
        // 둘다 버리는 경우
        bt(l + 1, r + 1, s);
        // 오른쪽만 버리는 경우
        if (left[l] > right[r]) {
            bt(l, r + 1, s + right[r]);
        }
    }
}