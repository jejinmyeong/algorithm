import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int ans = 0;

        for (int i = K - X ; i <= K + X ; i++) {
            if (i >= A && i <= B) ans++;
        }

        System.out.println(ans == 0 ? "IMPOSSIBLE" : ans);
    }
}