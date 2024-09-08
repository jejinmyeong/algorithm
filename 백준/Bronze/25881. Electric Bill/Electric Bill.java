import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        int [] c = new int[n];

        for (int i = 0 ; i < n ; i++) {
            c[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0 ; i < n ; i++) {
            int m = 0;
            if (c[i] <= 1000) m += c[i] * a;
            else m += 1000 * a + (c[i] - 1000) * b;
            sb.append(c[i] + " " + m).append("\n");
        }

        System.out.print(sb);
    }
}
