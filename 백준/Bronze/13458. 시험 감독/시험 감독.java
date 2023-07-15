import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [] p = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long ans = N;

        for (int i = 0 ; i < N ; i++) {
            p[i] -= B;
            if (p[i] <= 0) continue;
            ans += (long) Math.ceil((double) p[i] / C);
        }

        System.out.println(ans);
    }
}