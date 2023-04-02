import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int [] dist = new int[N - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N - 1 ; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long [] price = new long[N];

        price[0] = Long.parseLong(st.nextToken());

        long ans = price[0] * dist[0];
        for (int i = 1 ; i < N - 1 ; i++) {
            long p = Long.parseLong(st.nextToken());
            if (price[i - 1] > p) {
                price[i] = p;
            } else {
                price[i] = price[i - 1];
            }
            ans += price[i] * dist[i];
        }

        System.out.println(ans);
    }
}
