package J2023Mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main_boj_9935_문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String explosionStr = br.readLine();

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0 ; i < str.length() ; i++) {
            char c = str.charAt(i);

            if (deque.size() >= explosionStr.length() - 1 && c == explosionStr.charAt(explosionStr.length() - 1)) {
                Stack<Character> stack = new Stack<>();
                stack.push(c);

                if (explosionStr.length() < 2) continue;

                for (int j = explosionStr.length() - 2 ; j >= 0 ; j--) {
                    if (deque.peekLast() == explosionStr.charAt(j)) {
                        stack.push(deque.pollLast());
                    } else {
                        while (!stack.isEmpty()) {
                            deque.offer(stack.pop());
                        }
                        break;
                    }
                }
            } else deque.offer(c);
        }

        if (deque.isEmpty()) {
            sb.append("FRULA");
        } else {
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
            }
        }

        System.out.println(sb);

    }
}
