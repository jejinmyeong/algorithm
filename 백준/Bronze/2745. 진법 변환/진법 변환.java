import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int ans = 0;

        for (int i = 1 ; i <= N.length() ; i++) {
            char n = N.charAt(N.length() - i);

            if (n >= '0' && n <= '9') {
                ans += (n - '0') * (int) Math.pow(B, i - 1);
            } else {
                ans += (n - 'A' + 10) * (int) Math.pow(B, i - 1);
            }
        }

        System.out.println(ans);
    }
}