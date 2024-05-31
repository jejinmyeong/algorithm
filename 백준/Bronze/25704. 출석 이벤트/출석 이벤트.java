import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        int min = P;

        if (N < 5) {
            min = P;
        } else if (N < 10) {
            min = P - 500;
        } else if (N < 15) {
            min = (int) Math.min(P - 500, P * 0.9);
        } else if (N < 20) {
            min = (int) Math.min(P - 2000, P * 0.9);
        } else {
            min = (int) Math.min(P - 2000, P * 0.75);
        }

        if (min < 0) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}