import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int [] A = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1 ; i < N ; i++) {
            min = Math.min(min, (A[i - 1] + A[i]) * X);
        }

        System.out.println(min);
    }
}