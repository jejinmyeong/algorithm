import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        int ans = 0;
        boolean flag = false;

        for (int i = 0 ; i < input.length() ; i++) {
            char now = input.charAt(i);
            if (now == '(') {
                stack.push(now);
                flag = true;
            }
            else {
                stack.pop();
                if (flag) ans += stack.size();
                else ans += 1;
                flag = false;
            }

        }

        System.out.println(ans);
    }
}