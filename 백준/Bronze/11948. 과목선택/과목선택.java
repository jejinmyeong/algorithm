import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int sum = 0;
        for (int i = 0 ; i < 4 ; i++) {
            int s = Integer.parseInt(br.readLine());

            sum += s;
            queue.offer(s);
        }

        sum -= queue.poll();
        queue.clear();

        int E = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        sum += Math.max(E, F);

        System.out.println(sum);
    }
}