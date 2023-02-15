package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            String c = st.nextToken();

            if ("push".equals(c)) queue.offer(Integer.parseInt(st.nextToken()));
            else if ("pop".equals(c)) sb.append(queue.isEmpty() ? "-1" : queue.poll()).append("\n");
            else if ("size".equals(c)) sb.append(queue.size()).append("\n");
            else if ("empty".equals(c)) sb.append(queue.isEmpty() ? "1" : "0").append("\n");
            else if ("front".equals(c)) sb.append(queue.isEmpty() ? "-1" : queue.peek()).append("\n");
            else if ("back".equals(c)) sb.append(queue.isEmpty() ? "-1" : queue.get(queue.size() - 1)).append("\n");
        }

        System.out.print(sb);
    }
}
