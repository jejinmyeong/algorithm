import java.util.*;
import java.io.*;

public class Solution {
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1 ; t <= T ; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String input = br.readLine();
            HashSet<String> set = new HashSet<>();
            Deque<Character> deque = new LinkedList<>();

            String num = "";
            for (int i = 0 ; i < N ; i++) {
                char c = input.charAt(i);

                deque.offerLast(c);
                num += c;

                if (num.length() == N / 4) {
                    set.add(num);
                    num = "";
                }
            }

            for (int i = 1 ; i < N / 4 ; i++) {
                deque.offerFirst(deque.pollLast());
                Deque<Character> temp = new LinkedList<>();
                while (!deque.isEmpty()) {
                    char now = deque.poll();
                    num += now;

                    if (num.length() == N / 4) {
                        set.add(num);
                        num = "";
                    }

                    temp.offerLast(now);
                }
                deque = temp;
            }

            Integer [] arr = new Integer[set.size()];

            int idx = 0;
            for (String n : set) {
                arr[idx++] = Integer.parseInt(n, 16);
            }

            Arrays.sort(arr, Collections.reverseOrder());

            sb.append("#" + t + " " + arr[M - 1]).append("\n");
        }
        System.out.println(sb);
    }
}