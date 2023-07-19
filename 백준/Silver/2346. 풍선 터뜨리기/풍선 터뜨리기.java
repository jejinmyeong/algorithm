import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 2 ; i <= N ; i++) {
            deque.offer(i);
        }

        int [] arr = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sb.append("1 ");

        int M = arr[1];

        while (!deque.isEmpty()) {

            if (M < 0) {
                for (int j = 1 ; j < -M ; j++) {
                    deque.offerFirst(deque.pollLast());
                }

                int now = deque.pollLast();
                M = arr[now];
                sb.append(now).append(" ");

            } else {
                for (int j = 1 ; j < M ; j++) {
                    deque.offer(deque.poll());
                }

                int now = deque.poll();
                M = arr[now];
                sb.append(now).append(" ");

            }
        }

        System.out.println(sb);
    }
}