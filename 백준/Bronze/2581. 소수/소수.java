import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean [] prime = new boolean[10001];

        prime[0] = true;
        prime[1] = true;
        
        for (int i = 2 ; i <= 10000 ; i++) {
            for (int j = i * 2 ; j <= 10000 ; j += i) {
                prime[j] = true;
            }
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = M ; i <= N ; i++) {
            if (!prime[i]) {
                sum += i;
                min = Math.min(min, i);
            }
        }

        if (sum == 0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
