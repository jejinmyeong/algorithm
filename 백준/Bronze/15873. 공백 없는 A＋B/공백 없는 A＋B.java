import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N % 10 == 0) {
            N /= 100;
            System.out.println(10 + N);
        } else {
            int a = N % 10;
            
            N /= 10;
            
            if (N == 10) {
                System.out.println(10 + a);
            } else {
                System.out.println(a + N);
            }
        }
    }
}