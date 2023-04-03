import java.io.*;
import java.util.*;

public class Main {
    static class OilBank implements Comparable<OilBank> {
        int a, b;

        OilBank(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(OilBank o) {
            if (this.a == o.a) return this.b - o.b;
            return this.a - o.a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        OilBank [] oilBanks = new OilBank[N + 1];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            oilBanks[i] = new OilBank(a, b);
        }



        st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        oilBanks[N] = new OilBank(L, 0);
        Arrays.sort(oilBanks
        );
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int ans = 0;
        int now = 0;

        for (int i = 0 ; i <= N ; i++) {
            // 현재 위치까지 이동하는데 필요한 기름의 양을 현재 기름의 양에서 뺌
            P -= oilBanks[i].a - now;

            // 만약 P의 값이 0보다 작으면 이전의 주유소에서 기름을 넣었어야 하므로 queue에서 하나 뺌
            while(P < 0) {
                // 단, queue가 비어있을 경우 -1 출력하고 return
                if (queue.isEmpty()) {
                    System.out.println(-1);
                    return;
                }
                P += queue.poll();
                ans++;
            }

            // 현재 위치의 주유소에서 넣을 수 있는 기름을 큐에 넣음
            queue.offer(oilBanks[i].b);
            now = oilBanks[i].a;
        }

        System.out.println(ans);
    }
}