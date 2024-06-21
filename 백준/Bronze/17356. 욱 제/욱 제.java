import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        double M = (B - A) / 400d;

        double ans = 1 / (1 + Math.pow(10, M));

        System.out.println(BigDecimal.valueOf(ans));

    }
}