import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int ans = 0;

        while (N-- > 0) {
            String str = br.readLine();

            Stack<Character> stack = new Stack<>();

            for (int i = 0 ; i < str.length() ; i++) {
                char now = str.charAt(i);
                if (stack.isEmpty() || stack.peek() != now) {
                    stack.push(now);
                    continue;
                }

                stack.pop();
            }

            if (stack.isEmpty()) ans++;
        }

        System.out.println(ans);
    }
}