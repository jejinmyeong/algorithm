import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1 ; i <= K ; i++) {
            N -= i;
            if (N < 0) break;
        }

        if (N >= 0) {
            if (N % K > 0) System.out.println(K);
            else System.out.println(K - 1);
        } else {
            System.out.println(-1);
        }
    }
}