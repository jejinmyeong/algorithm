import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int x = 1;
        int y = 1;

        for (int i = 3 ; i < D ; i++) {
            int temp = x;
            x = x + y;
            y = temp;
        }

        int A = 1;

        while (true) {
            if ((K - y * A) % x == 0) {
                System.out.println(A);
                System.out.println((K - y * A) / x);
                break;
            }

            A++;
        }
    }

}