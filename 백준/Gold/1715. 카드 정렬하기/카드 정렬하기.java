import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static int [] cards;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        cards = new int[N];

        for (int i = 0 ; i < N ; i++) {
            cards[i] = Integer.parseInt(br.readLine());
        }

        bfs();

        System.out.println(ans);
    }

    static void bfs () {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0 ; i < N ; i++) {
            queue.offer(cards[i]);
        }

        while (queue.size() != 1) {
            int num1 = queue.poll();
            int num2 = queue.poll();
            ans += num1 + num2;
            queue.offer(num1 + num2);
        }
    }
}
