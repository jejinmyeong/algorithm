package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_boj_10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            String c = st.nextToken();

            if ("push_front".equals(c)) deque.offerFirst(Integer.parseInt(st.nextToken()));
            else if ("push_back".equals(c)) deque.offerLast(Integer.parseInt(st.nextToken()));
            else if ("pop_front".equals(c)) sb.append(deque.isEmpty() ? "-1" : deque.pollFirst()).append("\n");
            else if ("pop_back".equals(c)) sb.append(deque.isEmpty() ? "-1" : deque.pollLast()).append("\n");
            else if ("size".equals(c)) sb.append(deque.size()).append("\n");
            else if ("empty".equals(c)) sb.append(deque.isEmpty() ? "1" : "0").append("\n");
            else if ("front".equals(c)) sb.append(deque.isEmpty() ? "-1" : deque.peekFirst()).append("\n");
            else if ("back".equals(c)) sb.append(deque.isEmpty() ? "-1" : deque.peekLast()).append("\n");
        }

        System.out.print(sb);
    }
}
