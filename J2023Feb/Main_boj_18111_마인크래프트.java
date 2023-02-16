package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_18111_마인크래프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int [] blocks = new int[257];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                blocks[Integer.parseInt(st.nextToken())]++;
            }
        }
        int height = 0;
        int time = Integer.MAX_VALUE;

        for (int i = 256 ; i >= 0 ; i--) {
            int temp = B;
            int t = 0;

            // 현재 높이 보다 높은 블록 깎기
            for (int j = 256 ; j > i ; j--) {
                t += (j - i) * (blocks[j]) * 2;
                temp += (j - i) * (blocks[j]);
            }

            if (time <= t) continue;

            for (int j = i - 1 ; j >= 0 ; j--) {
                t += (i - j) * (blocks[j]);
                temp -= (i - j) * (blocks[j]);

                if (temp < 0) break;
            }

            if (temp >= 0) {
                if (t < time) {
                    time = t;
                    height = i;
                }
            }
        }

        System.out.println(time + " " + height);

    }
}
