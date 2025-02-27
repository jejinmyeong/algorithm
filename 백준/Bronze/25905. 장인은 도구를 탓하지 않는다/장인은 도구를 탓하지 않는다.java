import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double [] p = new double[10];

        for (int i = 0; i < 10; i++) {
            p[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(p);

        double ans = 1;

        for (int i = 1; i <= 9; i++) {
            ans *= p[i] / i;
        }

        System.out.println(ans * 1e9);

    }
}
