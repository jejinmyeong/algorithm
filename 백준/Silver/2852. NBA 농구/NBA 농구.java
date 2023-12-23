import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static class Score implements Comparable<Score> {
        int n, t;

        Score (int n, int t) {
            this.n = n;
            this.t = t;
        }

        @Override
        public int compareTo(Score o) {
            return this.t - o.t;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Score [] scores = new Score[N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            String time = st.nextToken();

            st = new StringTokenizer(time, ":");

            int mm = Integer.parseInt(st.nextToken());
            int ss = Integer.parseInt(st.nextToken());

            scores[i] = new Score(n, mm * 60 + ss);
        }

        Arrays.sort(scores);

        int SA = 0;
        int SB = 0;

        int TA = 0;
        int TB = 0;

        int BT = 0;

        for (int i = 0 ; i < N ; i++) {
            Score now = scores[i];

            if (SA > SB) {
                TA += now.t - BT;
            } else if (SB > SA) {
                TB += now.t - BT;
            }

            BT = now.t;

            if (now.n == 1) {
                SA++;
            } else {
                SB++;
            }
        }

        if (SA > SB) {
            TA += 48 * 60 - BT;
        } else if (SB > SA) {
            TB += 48 * 60 - BT;
        }

        int MMA = TA / 60;
        int SSA = TA % 60;
        int MMB = TB / 60;
        int SSB = TB % 60;

        sb.append(MMA < 10 ? "0": "").append(MMA).append(":").append(SSA < 10 ? "0" : "").append(SSA).append("\n");
        sb.append(MMB < 10 ? "0": "").append(MMB).append(":").append(SSB < 10 ? "0" : "").append(SSB);

        System.out.println(sb);

    }
}