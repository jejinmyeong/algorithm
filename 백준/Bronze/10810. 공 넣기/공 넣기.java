import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] baskets = new int[N + 1];

        for (int m = 0 ; m < M ; m++) {
            st = new StringTokenizer(br.readLine());

            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            for (int i = I ; i <=J ; i++) {
                baskets[i] = K;
            }
        }

        for (int i = 1 ; i <= N ; i++) {
            sb.append(baskets[i]).append(" ");
        }

        System.out.println(sb);

    }
}