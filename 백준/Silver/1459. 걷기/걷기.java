import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        long ans = 0;

        // Math.min(X, Y) , Math.min(X, Y) 까지 보냄
        if (2 * W > S) {
            ans += Math.min(X, Y) * S;
        } else {
            ans += Math.min(X, Y) * 2 * W;
        }

        if (2 * W > 2 * S) {
            long length = Math.abs(X - Y);
            if (length % 2 == 0) {
                ans += length * S;
            } else {
                ans += (length - 1) * S;
                ans += W;
            }
        } else {
            ans += Math.abs(X - Y) * W;
        }



        System.out.println(ans);


    }
}