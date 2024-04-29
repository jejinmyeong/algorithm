import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();

        int [] visitor = new int[N];

        st = new StringTokenizer(br.readLine());

        int ans = 0;
        int cnt = 0;
        int max = 0;

        for (int i = 0 ; i < N ; i++) {
            int visit = Integer.parseInt(st.nextToken());

            max += visit;
            queue.offer(visit);
            if (queue.size() > X) {
                max -= queue.poll();
            }

            if (max > ans) {
                ans = max;
                cnt = 1;
            } else if (max == ans) {
                cnt++;
            }
        }
        
        if (ans == 0) {
            System.out.println("SAD");
            return;
        }

        sb.append(ans).append("\n");
        sb.append(cnt);

        System.out.println(sb);
    }
}
