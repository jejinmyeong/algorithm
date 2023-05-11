import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> stick = new PriorityQueue<>();

        stick.offer(64);
        int sum = 64;

        while (X != sum) {
            int min = stick.poll();
            int mid = min / 2;

            stick.offer(mid);

            if (sum - mid < X) {
                stick.offer(mid);
            } else {
                sum -= mid;
            }
        }

        System.out.println(stick.size());
    }
}