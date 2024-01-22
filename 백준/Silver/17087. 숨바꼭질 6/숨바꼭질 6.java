import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int [] A = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            A[i] = Math.abs(Integer.parseInt(st.nextToken()) - S);
        }

        int gcd = A[0];

        for (int i = 1 ; i < N ; i++) {
            gcd = gcd(gcd, A[i]);
        }

        System.out.println(gcd);

    }

    static int gcd (int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}