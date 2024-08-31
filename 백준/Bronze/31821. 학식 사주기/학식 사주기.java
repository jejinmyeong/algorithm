import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] A = new int[N];

        for (int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int M = Integer.parseInt(br.readLine());

        int ans = 0;

        for (int i = 0 ; i < M ; i++) {
            ans += A[Integer.parseInt(br.readLine()) - 1];
        }

        System.out.println(ans);
    }
}
