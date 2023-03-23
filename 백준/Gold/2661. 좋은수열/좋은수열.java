import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dfs(0, "");
    }

    static void dfs(int cnt, String temp) {
        if (cnt == N) {
            System.out.println(temp);
            System.exit(0);
            return;
        }

        for (int i = 1 ; i <= 3 ; i++) {
            String next = temp + i;
            boolean flag = true;
            for (int j = 1 ; j <= next.length() / 2 ; j++) {
                if (!isGoodSeq(next, j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) dfs(cnt + 1, next);
        }
    }

    static boolean isGoodSeq (String next, int len) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < next.length() ; i++) {
            stack.push(next.charAt(i));
        }

        Queue<Character> left = new LinkedList<>();
        for (int i = 0 ; i < len ; i++) {
            left.offer(stack.pop());
        }
        for (int i = 0 ; i < len ; i++) {
            if (left.poll() != stack.pop()) return true;
        }
        return false;
    }
}
