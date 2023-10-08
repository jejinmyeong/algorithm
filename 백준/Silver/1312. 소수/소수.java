import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int res = A % B;

        for (int i = 0 ; i < N - 1 ; i++) {
            res *= 10;
            res %= B;
        }

        res *= 10;

        System.out.println(res / B);
    }
}
