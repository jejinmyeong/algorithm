import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long factorial = 1L;

        for (long i = 1L ; i <= n ; i++) {
            factorial *= i;
        }

        long week = factorial / (7 * 24 * 60 * 60);

        System.out.println(week);
    }
}
