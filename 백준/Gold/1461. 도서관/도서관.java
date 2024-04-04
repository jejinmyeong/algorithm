import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> b - a);


        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            int d = Integer.parseInt(st.nextToken());

            if (d > 0) {
                right.offer(d);
            } else {
                left.offer(-d);
            }
        }

        int max = 0;
        if (left.isEmpty()) {
            max = right.peek();
        } else if (right.isEmpty()) {
            max = left.peek();
        } else {
            max = Math.max(left.peek(), right.peek());
        }

        int ans = 0;

        while (!left.isEmpty()) {
            int now = left.poll();
            for (int i = 0 ; i < M - 1 ; i++) {
                left.poll();

                if (left.isEmpty()) {
                    break;
                }
            }

            ans += now * 2;
        }

        while (!right.isEmpty()) {
            int now = right.poll();
            for (int i = 0 ; i < M - 1 ; i++) {
                right.poll();

                if (right.isEmpty()) {
                    break;
                }
            }

            ans += now * 2;
        }

        ans -= max;
        System.out.println(ans);
    }
}