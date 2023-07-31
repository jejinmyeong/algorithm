import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Flower implements Comparable<Flower> {
        int start, end;

        Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            if (this.start == o.start) return o.end - this.end;
            return this.start - o.start;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int [] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int [] sum = new int[13];

        for (int i = 1 ; i <= 12 ; i++) {
            sum[i] += sum[i - 1] + days[i];
        }


        Flower [] flowers = new Flower[N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            flowers[i] = new Flower(sum[startMonth - 1] + startDay, sum[endMonth - 1] + endDay);
        }

        Arrays.sort(flowers);

        int start = 0;
        int end = sum[2] + 1; // 3월 1일
        int cnt = 0;

        for (int i = 0 ; i < N ; i++) {
            if (end >= flowers[i].end || end < flowers[i].start) continue;

            if (start < flowers[i].start) {
                cnt++;
                start = end;
            }
            end = flowers[i].end;

            if (end > sum[11]) break;
        }

        if (end <= sum[11]) System.out.println(0);
        else System.out.println(cnt);

    }
}