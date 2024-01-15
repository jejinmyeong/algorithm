import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        int num = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = m - 1 ; i >= 0 ; i--) {
            num += (int)Math.pow(A, i) * Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        while (num != 0) {
            stack.push(num % B);

            num /= B;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

}