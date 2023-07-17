import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        boolean [] isPrimeNum = new boolean[1_000_001];

        Arrays.fill(isPrimeNum, true);

        for (int i = 2 ; i <= 1000 ; i++) {
            for (int j = i + i ; j <= 1_000_000 ; j += i) {
                isPrimeNum[j] = false;
            }
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int cnt = 0;

            for (int i = 2 ; i <= N / 2 ; i++) {
                if (!isPrimeNum[i]) continue;
                if (isPrimeNum[N - i]) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}