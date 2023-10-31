import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> trucks = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            trucks.offer(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0 ; i < W ; i++) {
            queue.offer(0);
        }

        int ans = 0;
        int now = 0;
        while (!queue.isEmpty()) {
            ans++;
            now -= queue.poll();

            if (!trucks.isEmpty()) {
                if (trucks.peek() + now <= L) {
                    now += trucks.peek();
                    queue.offer(trucks.poll());
                } else {
                    queue.offer(0);
                }
            }
        }

        System.out.println(ans);

    }
}