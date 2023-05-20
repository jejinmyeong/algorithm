import java.math.*;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        String input = br.readLine();

        for (int i = 0 ; i < N ; i++) {
            int now = input.charAt(i) - '0';

            if (stack.isEmpty() || stack.peek() >= now) {
                stack.push(now);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() < now && K > 0) {
                stack.pop();
                K--;
            }

            stack.push(now);
        }

        while (K > 0) {
            stack.pop();
            K--;
        }

        System.out.println(stack.stream().map(Objects::toString).collect(Collectors.joining("")));
    }
}

