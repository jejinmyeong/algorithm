import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        double len = Math.sqrt(N * N + M * M);

        double ans = len;

        if (len >= D) {
            int cnt = (int) (len / D);

            ans = Math.min(ans, Math.min(T * cnt + (len - (D * cnt)), T * (cnt + 1)));
        } else {
            ans = Math.min(ans, Math.min(T + (D - len), T * 2));
        }

        System.out.println(ans);
    }
}
