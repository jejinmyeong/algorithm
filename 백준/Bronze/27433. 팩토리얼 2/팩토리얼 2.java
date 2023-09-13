import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long factorial = 1;

        for (int i = 2 ; i <= N ; i++) {
            factorial *= i;
        }

        System.out.println(factorial);
    }
}
