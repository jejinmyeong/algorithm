import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());

            switch (c) {
                case 1: {
                    int X = Integer.parseInt(st.nextToken());
                    deque.addFirst(X);
                    break;
                }
                case 2: {
                    int X = Integer.parseInt(st.nextToken());
                    deque.addLast(X);
                    break;
                }
                case 3: {
                    if (deque.isEmpty()) sb.append(-1);
                    else sb.append(deque.pollFirst());
                    sb.append("\n");
                    break;
                }
                case 4: {
                    if (deque.isEmpty()) sb.append(-1);
                    else sb.append(deque.pollLast());
                    sb.append("\n");
                    break;
                }
                case 5: {
                    sb.append(deque.size()).append("\n");
                    break;
                }
                case 6: {
                    if (deque.isEmpty()) sb.append(1);
                    else sb.append(0);
                    sb.append("\n");
                    break;
                }
                case 7: {
                    if (deque.isEmpty()) sb.append(-1);
                    else sb.append(deque.peekFirst());
                    sb.append("\n");
                    break;
                }
                case 8: {
                    if (deque.isEmpty()) sb.append(-1);
                    else sb.append(deque.peekLast());
                    sb.append("\n");
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}