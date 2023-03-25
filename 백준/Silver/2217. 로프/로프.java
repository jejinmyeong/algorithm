import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] ropes = new int[N];

        for (int i = 0 ; i < N ; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);
        int ans = 0;
        for (int i = 0 ; i < N ; i++) {
            ans = Math.max(ans, ropes[i] * (N - i));
        }

        System.out.println(ans);

    }
}
