import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        boolean [] prime = new boolean[1_300_002];

        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2 ; i <= 1_300_001 ; i++) {
            for (int j = i * 2 ; j <= 1_300_001 ; j += i) {
                prime[j] = false;
            }
        }

        for (int i = N ; i <= 1_300_001 ; i++) {
            if (!prime[i]) continue;
            String num = String.valueOf(i);
            boolean flag = true;
            for (int j = 0 ; j < num.length() / 2 ; j++) {
                if (num.charAt(j) != num.charAt(num.length() - 1 - j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println(num);
                return;
            }
        }
    }
}
