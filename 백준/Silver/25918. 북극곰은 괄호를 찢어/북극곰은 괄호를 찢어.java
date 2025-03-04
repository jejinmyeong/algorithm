import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String S = br.readLine();

        Stack<Character> stack = new Stack<>();

        int ans = 0;

        for (char c : S.toCharArray()) {
            if (stack.isEmpty()) stack.push(c);
            else if (stack.peek() != c) {
                ans = Math.max(ans, stack.size());
                stack.pop();
            }
            else stack.push(c);
        }

        System.out.println(stack.isEmpty() ? ans : -1);
    }
}