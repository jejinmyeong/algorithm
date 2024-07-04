import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int max = -1;

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            if (S + T <= X) {
                max = Math.max(max, S);
            }
        }

        System.out.println(max);
    }
}
