import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean [] prime = new boolean[N + 1];

        Arrays.fill(prime, true);

        for (int i = 2 ; i <= N ; i++) {
            if (!prime[i]) continue;
            for (int j = i ; j <= N ; j += i) {
                if (!prime[j]) continue;
                prime[j] = false;
                K--;

                if (K == 0) {
                    System.out.println(j);
                    return;
                }
            }

        }
    }
}
