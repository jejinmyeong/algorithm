package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_boj_1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (queue.isEmpty()) sb.append(0).append("\n");
                else sb.append(queue.poll()).append("\n");
            } else queue.offer(x);
        }

        System.out.print(sb);

    }
}
