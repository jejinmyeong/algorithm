import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        boolean [] primeNumber = new boolean[10000];

        Arrays.fill(primeNumber, true);

        primeNumber[0] = primeNumber[1] = false;

        for (int i = 2 ; i < 10000 ; i++) {
            for (int j = i + i ; j < 10000 ; j += i) {
                primeNumber[j] = false;
            }
        }

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int current = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new ArrayDeque<>();

            boolean [] visited = new boolean[10000];

            visited[current] = true;
            queue.offer(current);

            int ans = 0;

            loop: while (!queue.isEmpty()) {
                int end = queue.size();

                for (int i = 0 ; i < end ; i++) {
                    int now = queue.poll();

//                    System.out.println(now);

                    if (now == target) {
                        break loop;
                    }

                    // 4자리
                    int div = 1;
                    for (int j = 1 ; j <= 4 ; j++) {
                        // 현재 자리수의 값
                        int v = now % (div * 10) / div;
                        for (int k = 1 ; k < 10 ; k++) {
                            int next = now - (v * div) + ((k + v) % 10) * div;

                            if (!primeNumber[next] || visited[next] || next < 1000) continue;

                            visited[next] = true;
                            queue.offer(next);
                        }
                        div *= 10;
                    }
                }
                ans++;
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}