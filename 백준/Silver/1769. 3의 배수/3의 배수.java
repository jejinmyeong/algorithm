import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String X = br.readLine();
        int cnt = 0;

        while (X.length() > 1) {
            long Y = 0;
            for (int i = 0 ; i < X.length() ; i++) {
                Y += X.charAt(i) - '0';
            }

            X = String.valueOf(Y);
            cnt++;
        }

        int res = Integer.parseInt(X);

        System.out.println(cnt);
        System.out.println(res % 3 == 0 ? "YES" : "NO");
    }
}