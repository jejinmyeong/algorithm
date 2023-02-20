package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_1629_곱셈 {

    static int A, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(mul(B));
    }

    static long mul (int k) {
        if (k == 1) return A % C;

        long m = mul(k / 2);

        long res = (m * m) % C;

        if (k % 2 != 0) res = (res * A) % C;

        return res;
    }
}