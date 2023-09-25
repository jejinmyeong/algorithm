import java.util.*;
import java.io.*;

public class Main {
    static class Pos {
        int x, y, c;

        Pos(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1 ; i <= N ; i++) {
            queue.offer(i);
        }

        while (queue.size() != 1) {
            sb.append(queue.poll()).append(" ");

            queue.offer(queue.poll());
        }

        sb.append(queue.poll());

        System.out.println(sb);
    }
}