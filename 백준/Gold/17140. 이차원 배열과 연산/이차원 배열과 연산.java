import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    static class Count implements Comparable<Count> {
        int key, cnt;

        Count (int key, int cnt) {
            this.key = key;
            this.cnt = cnt;
        }

        @Override
        public int compareTo (Count o) {
            if (this.cnt == o.cnt) return this.key - o.key;
            return this.cnt - o.cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [][] list = new int[101][101];

        for (int i = 1 ; i <= 3 ; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1 ; j <= 3 ; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int row = 3, col = 3;
        while (cnt < 101 && list[R][C] != K) {
            if (row <= col) {
                int temp = row;
                for (int i = 1 ; i <= col ; i++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int j = 1 ; j <= row ; j++) {
                        if (list[i][j] == 0) continue;
                        map.compute(list[i][j], (key, value) -> value == null ? 1 : value + 1);
                    }

                    PriorityQueue<Count> queue = new PriorityQueue<>();
                    map.forEach((key, value) -> queue.offer(new Count(key, value)));

                    int idx = 1;
                    while (!queue.isEmpty()) {
                        Count now = queue.poll();

                        list[i][idx++] = now.key;
                        list[i][idx++] = now.cnt;
                    }

                    temp = Math.max(temp, idx);

                    while (idx < 100) {
                        list[i][idx++] = 0;
                        list[i][idx++] = 0;
                    }
                }

                row = temp;
            } else {
                int temp = col;
                for (int j = 1 ; j <= row ; j++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int i = 1 ; i <= col ; i++) {
                        if (list[i][j] == 0) continue;
                        map.compute(list[i][j], (key, value) -> value == null ? 1 : value + 1);
                    }

                    PriorityQueue<Count> queue = new PriorityQueue<>();
                    map.forEach((key, value) -> queue.offer(new Count(key, value)));

                    int idx = 1;
                    while (!queue.isEmpty()) {
                        Count now = queue.poll();

                        list[idx++][j] = now.key;
                        list[idx++][j] = now.cnt;
                    }

                    temp = Math.max(temp, idx);

                    while(idx < 100) {
                        list[idx++][j] = 0;
                        list[idx++][j] = 0;
                    }
                }

                col = temp;
            }

            cnt++;
        }

        if (cnt > 100) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }

    }
}