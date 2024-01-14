import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int idx = 0;

        for (int i = 1 ; i <= N ; i++) {
            if (N % i == 0) {
                idx++;
            }

            if (idx == K) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);

    }
}