import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        sb.append("Gnomes:").append("\n");
        
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if (a >= b && b >= c || a <= b && b <= c) {
                sb.append("Ordered");
            } else {
                sb.append("Unordered");
            }
            
            sb.append("\n");
        }

        System.out.print(sb);

    }
}
