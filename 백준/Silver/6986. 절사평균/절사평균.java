import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        double [] score = new double[N];

        for (int i = 0 ; i < N ; i++) {
            score[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(score);

        double trimSum = 0.0;
        double calSum = 0.0;

        for (int i = 0 ; i < N ; i++) {
            if (i < K) {
                calSum += score[K];
                continue;
            } else if (i > N - K - 1) {
                calSum += score[N - 1 - K];
                continue;
            }

            trimSum += score[i];
            calSum += score[i];
        }

        System.out.printf("%.2f", Math.round((trimSum / (N - 2 * K)) * 100) / 100d);
        System.out.println();
        System.out.printf("%.2f", Math.round((calSum / N) * 100) / 100d);

    }
}
