import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if (K >= N) {
            System.out.println(0);
            return;
        }

        int [] pos = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pos);

        Integer [] dif = new Integer[N - 1];

        for (int i = 0 ; i < N - 1 ; i++) {
            dif[i] = pos[i + 1] - pos[i];
        }

        Arrays.sort(dif, Collections.reverseOrder());

        int ans = 0;

        for (int i = K - 1 ; i < N - 1 ; i++) {
            ans += dif[i];
        }

        System.out.println(ans);
    }
}