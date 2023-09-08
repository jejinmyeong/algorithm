import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long ans = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0 ; i < N ; i++) {
            int now = Integer.parseInt(br.readLine());

            if (stack.isEmpty()) {
                stack.push(now);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() <= now) {
                stack.pop();
            }

            ans += stack.size();

            stack.push(now);
        }

        System.out.println(ans);
    }
}
