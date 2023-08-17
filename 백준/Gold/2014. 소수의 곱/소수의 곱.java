import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> queue = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        int [] arr = new int[K];

        for (int i = 0 ; i < K ; i++) {
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
            queue.offer((long) k);
        }

        long ans = 0;

        while (N-- > 0) {
            ans = queue.poll();

            for (int i = 0 ; i < K ; i++) {
                long next = ans * arr[i];

                if (next >= (2L << 30)) continue;

                queue.offer(next);

                if (ans % arr[i] == 0) break;
            }
        }

        System.out.println(ans);
    }
}