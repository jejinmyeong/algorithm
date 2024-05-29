import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        int ans = 0;

        if (A < 0) {
            ans += (0 - A) * C;
            A = 0;
        }

        if (A == 0) {
            ans += D;
        }

        if (A < B) {
            ans += (B - A) * E;
            A = B;
        }

        System.out.println(ans);
    }
}