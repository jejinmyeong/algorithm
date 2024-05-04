import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());

        int start = 0;
        int end = L;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (A <= C * mid && B <= D * mid) end = mid - 1;
            else start = mid + 1;
        }

        System.out.println(L - start);
    }
}