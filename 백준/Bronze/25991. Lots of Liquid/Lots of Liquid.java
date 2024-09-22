import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        double sum = 0d;
        st = new StringTokenizer(br.readLine());

        while (N-- > 0) {
            double cur = Double.parseDouble(st.nextToken());
            sum += Math.pow(cur, 3);
        }

        System.out.print(Math.cbrt(sum));
    }
}
