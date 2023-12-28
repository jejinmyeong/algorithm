import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] p = new int[M];

        for (int i = 0 ; i < M ; i++) {
            p[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(p);

        int ans = 0;
        int price = 0;

        for (int i = 0 ; i < M ; i++) {
            if (ans < p[i] * ((M - i) > N ? N : (M - i))) {
                price = p[i];
                ans = p[i] * ((M - i) > N ? N : (M - i));
            }
        }

        System.out.println(price + " " + ans);
    }
}