import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        // 왼쪽에 연속된 0 개수
        int [] left1 = new int[N + 2];
        int [] left2 = new int[N + 2];

        // 오른쪽에 연속된 1 개수
        int [] right1 = new int[N + 2];
        int [] right2 = new int[N + 2];


        for (int i = 1 ; i <= N ; i++) {
            int c = Integer.parseInt(st.nextToken());

            if (c == 1) {
                left1[i] = 1;
                right1[i] = 1;
            } else {
                left2[i] = 1;
                right2[i] = 1;
            }
        }

        for (int i = 1 ; i <= N ; i++) {
            if (left1[i] == 0) continue;
            left1[i] = left1[i - 1] + left1[i];
        }

        for (int i = 1 ; i <= N ; i++) {
            if (left2[i] == 0) continue;
            left2[i] = left2[i - 1] + left2[i];
        }

        int ans = 0;

        for (int i = N - 1 ; i > 0 ; i--) {
            if (right1[i] == 0) continue;
            right1[i] = right1[i + 1] + right1[i];
            ans = Math.max(ans, right1[i]);
        }
        for (int i = N - 1 ; i > 0 ; i--) {
            if (right2[i] == 0) continue;
            right2[i] = right2[i + 1] + right2[i];
            ans = Math.max(ans, right2[i]);
        }

        for (int i = 0 ; i <= N ; i++) {
            ans = Math.max(ans, left1[i] + right2[i + 1]);
            ans = Math.max(ans, left2[i] + right1[i + 1]);
        }

        System.out.println(ans);

    }
}
