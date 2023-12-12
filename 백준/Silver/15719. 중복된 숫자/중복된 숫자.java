import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long N = Long.parseLong(br.readLine());
        long sum = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            sum += Long.parseLong(st.nextToken());
        }

        sum -= N * (N - 1) / 2;

        System.out.println(sum);

    }
}
