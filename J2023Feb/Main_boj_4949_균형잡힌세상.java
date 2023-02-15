package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_boj_4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            boolean flag = true;

            if (".".equals(input)) break;

            Stack<Character> stack = new Stack<>();

            for (int i = 0 ; i < input.length() ; i++) {
                char c = input.charAt(i);
                if (c == '[' || c == '(') {
                    stack.push(c);
                }
                else if (c == ']') {
                    if (stack.size() != 0 && stack.peek() == '[') stack.pop();
                    else {
                        flag = false;
                        break;
                    }
                }
                else if (c == ')') {
                    if (stack.size() != 0 && stack.peek() == '(') stack.pop();
                    else {
                        flag = false;
                        break;
                    }
                }
            }

            if (stack.size() == 0 && flag) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }

        System.out.print(sb);
    }
}
