import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> hamburger = new ArrayDeque<>();
        Queue<Integer> people = new ArrayDeque<>();

        String str = br.readLine();

        for (int i = 0 ; i < N ; i++) {
            char c = str.charAt(i);

            if (c == 'H') {
                hamburger.offer(i);
            } else if (c == 'P') {
                people.offer(i);
            }
        }

        int ans = 0;

        while (!hamburger.isEmpty() && !people.isEmpty()) {
            int hi = hamburger.peek();
            int pi = people.peek();

            if (Math.abs(pi - hi) <= K) {
                hamburger.poll();
                people.poll();
                ans++;
            } else {
                if (hi < pi) {
                    hamburger.poll();
                } else {
                    people.poll();
                }
            }
        }

        System.out.println(ans);
    }
}