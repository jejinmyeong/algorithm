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
        
        b -= a;
        
        if (b <= 0) {
            System.out.println(0);
        } else {
            int d = b / c;
            if (b % c != 0) d++;
            System.out.println(d);
        }
    }
}