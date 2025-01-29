import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int I = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            for (int j = 0 ; j < C ; j++) {
                if (T <= S + I * j) {
                    min = Math.min(min, S + I * j - T);
                    break;
                }
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
