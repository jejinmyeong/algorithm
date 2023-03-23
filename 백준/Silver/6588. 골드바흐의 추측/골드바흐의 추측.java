import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static ArrayList<Integer> arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean [] isPrimeNumber = new boolean[1000001];

        Arrays.fill(isPrimeNumber, true);

        for (int i = 2 ; i <= Math.sqrt(1000000) ; i++) {
            for (int j = i + i ; j <= 1000000 ; j += i) {
                isPrimeNumber[j] = false;
            }
        }

        while(true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            boolean flag = false;
            for (int i = 2 ; i <= N / 2 ; i++) {
                if (isPrimeNumber[i] && isPrimeNumber[N - i]) {
                    sb.append(N + " = " + i + " + " + (N - i)).append("\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) sb.append("Goldbach's conjecture is wrong.").append("\n");
        }

        System.out.print(sb);
    }
}
