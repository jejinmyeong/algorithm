import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];

        int start = 0;
        int end = N - 1;

        int sumL = 0;
        int sumR = 0;

        for (int i = 0 ; i < N ; i++) {
            if (sumL < sumR) {
                arr[start++] = N - i;
                sumL += N - i;
            } else {
                arr[end--] = N - i;
                sumR += N - i;
            }
        }

        for (int a: arr) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }
}