import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        if (T % 10 != 0) {
            System.out.println(-1);
            return;
        }

        int min = T / 60;
        int sec = T % 60;

        int A = min / 5;
        int B = min - A * 5;
        int C = sec / 10;

        System.out.println(A + " " + B + " " + C);
    }
}