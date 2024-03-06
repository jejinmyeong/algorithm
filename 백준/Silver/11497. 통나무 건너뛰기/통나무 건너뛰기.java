import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            Integer [] arr = new Integer[N];

            for (int i = 0 ; i < N ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, Collections.reverseOrder());

            Deque<Integer> deque = new ArrayDeque<>();

            int ans = 0;

            for (int i = 0 ; i < N ; i++) {
                int now = arr[i];

                if (deque.isEmpty()) {
                    deque.offer(now);
                    continue;
                }

                if (deque.peekFirst() - now > deque.peekLast() - now) {
                    ans = Math.max(ans, deque.peekFirst() - now);
                    deque.offerFirst(now);
                } else {
                    ans = Math.max(ans, deque.peekLast() - now);
                    deque.offerLast(now);
                }

                ans = Math.max(ans, Math.abs(deque.peekFirst() - deque.peekLast()));
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}