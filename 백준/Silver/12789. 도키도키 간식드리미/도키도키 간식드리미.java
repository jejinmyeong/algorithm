import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0 ; i < N ; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        int start = 1;
        while (!queue.isEmpty()) {
            // 현재 줄에서 가장 앞
            int now = queue.poll();

            // 현재 줄 가장 앞에 학생이 받을 차례인 경우
            if (now == start) {
                start++;

                while (!stack.isEmpty() && stack.peek() == start) {
                    stack.pop();
                    start++;
                }
                continue;
            }
            // 한 명씩 설 수 있는 공간에 가장 앞 학생의 차례인 경우
            while (!stack.isEmpty() && stack.peek() == start) {
                stack.pop();
                start++;
            }

            if (now != start) {
                stack.push(now);
            }
        }

        while (!stack.isEmpty()) {
            if (start != stack.peek()) break;
            else {
                start++;
                stack.pop();
            }
        }

        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
    }
}