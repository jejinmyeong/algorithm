import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] basket = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            basket[i] = i;
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int temp = basket[a];
            basket[a] = basket[b];
            basket[b] = temp;
        }

        for (int i = 1 ; i <= N ; i++) {
            sb.append(basket[i]).append(" ");
        }

        System.out.println(sb);

    }
}
