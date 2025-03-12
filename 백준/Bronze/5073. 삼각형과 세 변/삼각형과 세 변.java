import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            if (a + b <= c || b + c <= a || a + c <= b) {
                sb.append("Invalid\n");
            } else if (a == b && b == c) {
                sb.append("Equilateral\n");
            } else if (a == b || a == c || b == c) {
                sb.append("Isosceles\n");
            } else {
                sb.append("Scalene\n");
            }
        }

        System.out.print(sb);

    }
}

