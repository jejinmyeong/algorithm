import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Belt {
        int p;
        boolean robot;

        Belt(int p) {
            this.p = p;
            robot = false;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Belt [] belts = new Belt[2 * N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < 2 * N ; i++) {
            belts[i] = new Belt(Integer.parseInt(st.nextToken()));
        }

        int k = 0;
        int ans = 0;

        while (k < K) {
            ans++;
            // 로봇과 함께 회전
            Belt temp = belts[0];

            for (int i = 2 * N - 1 ; i > 0 ; i--) {
                belts[(i + 1) % (2 * N)] = belts[i];
            }
            belts[1] = temp;

            // 내릴수 있는 로봇 확인
            if (belts[N - 1].robot) belts[N - 1].robot = false;
            if (belts[N].robot) belts[N].robot = false;

            // 로봇 이동
            for (int i = N - 2 ; i >= 0 ; i--) {
                if (!belts[i].robot || belts[i + 1].robot || belts[i + 1].p == 0) continue;
                belts[i + 1].robot = true;
                belts[i + 1].p--;
                if (belts[i + 1].p == 0) k++;
                belts[i].robot = false;
            }

            // 로봇 올림
            if (!belts[0].robot && belts[0].p != 0) {
                belts[0].robot = true;
                belts[0].p--;
                if (belts[0].p == 0) k++;
            }
        }

        System.out.println(ans);
    }
}