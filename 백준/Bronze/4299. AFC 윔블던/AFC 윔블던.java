import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());

        // a + b = sum
        // a - b = sub
        // a = (sum + sub) / 2
        // b = sum - a

        if ((sum + sub) % 2 != 0) {
            System.out.println(-1);
            return;
        }

        int a = (sum + sub) / 2;
        int b = sum - a;

        if (a < 0 || b < 0) {
            System.out.println(-1);
            return;
        }

        if (a > b) {
            System.out.println(a + " " + b);
        } else {
            System.out.println(b + " " + a);
        }
    }
}
