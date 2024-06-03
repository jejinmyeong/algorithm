import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        while(true) {
            int N = Integer.parseInt(br.readLine());

            if (N == -1) break;

            sum += N;
        }

        System.out.println(sum);
    }
}