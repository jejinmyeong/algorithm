import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int ans = 0;

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), "-");

            st.nextToken();
            int x = Integer.parseInt(st.nextToken());

            if (x <= 90) ans++;
        }

        System.out.println(ans);
    }
}