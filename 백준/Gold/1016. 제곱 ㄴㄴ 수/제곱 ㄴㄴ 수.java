import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean [] isPrime = new boolean[(int) (max - min + 1)];

        for (long i = 2 ; i <= Math.sqrt(max) ; i++) {
            long pow = i * i;
            long start = min % pow == 0 ? min / pow : min / pow + 1;
            for (long j = start ; j * pow <= max ; j++) {
                isPrime[(int) ((j * pow) - min)] = true;
            }
        }

        int ans = 0;
        for (int i = 0 ; i < max - min + 1 ; i++) {
            if (!isPrime[i]) ans++;
        }

        System.out.println(ans);
    }
}
