import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int ucd;
        
        if (N == 2) {
            ucd = Math.abs(arr[0] - arr[1]);
        } else {
            ucd = ucd(Math.abs(arr[0] - arr[1]), Math.abs(arr[1] - arr[2]));
        }

        for (int i = 3 ; i < N ; i++) {
            ucd = ucd(ucd, Math.abs(arr[i] - arr[i - 1]));
        }

        for (int i = 2 ; i <= ucd ; i++) {
            if (ucd % i == 0) sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static int ucd(int a, int b) {
        return b == 0 ? a : ucd(b, a % b);
    }
}