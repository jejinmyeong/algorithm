import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (int i = 0 ; i < str.length() ; i++) {
                char now = str.charAt(i);

                if (now == '<') {
                    if (!left.isEmpty()) right.push(left.pop());
                } else if (now == '>') {
                    if (!right.isEmpty()) left.push(right.pop());
                } else if (now == '-') {
                    if (!left.isEmpty()) left.pop();
                }else {
                    left.push(now);
                }
            }

            while (!left.isEmpty()) right.push(left.pop());

            while (!right.isEmpty()) {
                sb.append(right.pop());
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}