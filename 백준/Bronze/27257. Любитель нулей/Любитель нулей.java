import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N % 10 == 0) {
            N /= 10;
        }

        int c = 0;
        while (N != 0) {
            if (N % 10 == 0) {
                c++;
            }
            N /= 10;
        }

        System.out.println(c);
    }
}
