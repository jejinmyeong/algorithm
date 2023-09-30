import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int P = B - A;
        int Q = B;

        int gcd = gcd(P, Q);

        System.out.println(P / gcd + " " + Q / gcd);
    }

    static int gcd (int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}