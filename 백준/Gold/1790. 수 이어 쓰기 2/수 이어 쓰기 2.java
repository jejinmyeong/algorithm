import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());

        long cnt = 9;
        long len = 1;

        while (k > len * cnt) {
            k -= (len * cnt);
            len++;
            cnt *= 10;
        }

        k -= 1;

        long num = (long) Math.pow(10, (len - 1)) + (k / len);

        if (num > N) {
            System.out.println(-1);
        } else {
            System.out.println(String.valueOf(num).charAt((int)(k % len)));
        }
    }
}