import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = 1 ; i <= Math.max(a , b); i++) {
            if (a % i == 0 && b % i == 0) {
                sb.append(i).append(" ").append(a / i).append(" ").append(b / i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
