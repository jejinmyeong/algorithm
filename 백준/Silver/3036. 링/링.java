import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int main = Integer.parseInt(st.nextToken());

        for (int i = 1 ; i < N ; i++) {
            int now = Integer.parseInt(st.nextToken());
            int gcd = gcd(main, now);
            sb.append(main / gcd).append("/").append(now / gcd).append("\n");
        }

        System.out.print(sb);
    }

    static int gcd (int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}