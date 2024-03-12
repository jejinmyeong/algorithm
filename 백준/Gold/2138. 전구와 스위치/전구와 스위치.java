import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean [] A = new boolean[N];
        boolean [] B = new boolean[N];

        String input = br.readLine();

        for (int i = 0 ; i < N ; i++) {
            if (input.charAt(i) == '1') {
                A[i] = true;
            }
        }

        input = br.readLine();

        for (int i = 0 ; i < N ; i++) {
            if (input.charAt(i) == '1') {
                B[i] = true;
            }
        }

        boolean [] C = A.clone();
        C[0] = !C[0];
        C[1] = !C[1];

        int res1 = toggle(N, A, B);
        int res2 = toggle(N, C, B);
        if (res2 != -1) res2 += 1;
        

        if (res1 == -1) {
            System.out.println(res2);
        } else if (res2 == -1) {
            System.out.println(res1);
        } else {
            System.out.println(Math.min(res1, res2));
        }

    }

    static int toggle(int n, boolean [] a, boolean [] b) {
        int cnt = 0;

        for (int i = 0 ; i < n - 1; i++) {
            if (a[i] != b[i]) {
                cnt++;
                a[i] = !a[i];
                a[i + 1] = !a[i + 1];
                if (i != n - 2) {
                    a[i + 2] = !a[i + 2];
                }
            }
        }

        return a[n - 1] != b[n - 1] ? -1 : cnt;
    }
}