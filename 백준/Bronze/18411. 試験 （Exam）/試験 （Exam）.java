import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int t = 0;
        
        if (a >= b && b >= c || b >= a && a >= c) {
            t += a + b;
        } else if (a >= c && c >= b || c >= a && a >= b) {
            t += a + c;
        } else {
            t += b + c;
        }

        System.out.println(t);
    }
}
