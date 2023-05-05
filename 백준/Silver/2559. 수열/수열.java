import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] temperatures = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        for (int i = 0 ; i < K ; i++) {
            sum += temperatures[i];
        }

        int ans = sum;

        for (int i = K ; i < N ; i++) {
            sum += temperatures[i];
            sum -= temperatures[i - K];

            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}
