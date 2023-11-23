import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] rank = new int[N];

        for (int i = 0 ; i < N ; i++) {
            rank[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rank);

        long ans = 0;

        for (int i = 0 ; i < N ; i++) {
            ans += Math.abs(i + 1 - rank[i]);
        }

        System.out.println(ans);
    }
}