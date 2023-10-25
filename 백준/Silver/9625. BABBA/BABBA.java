import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int A = 1;
        int B = 0;

        for (int i = 0 ; i < K ; i++) {
            int temp = A + B;
            A = B;
            B = temp;
        }

        System.out.println(A + " " + B);
    }
}
