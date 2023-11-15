import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] score = new int[N];

        for (int i = 0 ; i < N ; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;

        for (int i = N - 1; i > 0 ; i--) {
            if (score[i] <= score[i - 1]) {
                ans += score[i - 1] - score[i] + 1;
                score[i - 1] = score[i] - 1;
            }
        }

        System.out.println(ans);
    }
}