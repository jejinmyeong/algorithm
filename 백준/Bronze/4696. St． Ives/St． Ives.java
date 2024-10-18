import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double n = Double.parseDouble(br.readLine());
        double ans = 0;
        while (n != 0) {
            ans = 0;
            ans += n;
            ans += n * n;
            ans += n * n * n;
            ans += n * n * n * n;
            ans += 1;
            System.out.println(String.format("%.2f", ans));
            n = Double.parseDouble(br.readLine());
        }
    }
}
