import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static class Number implements Comparable<Number> {
        String n;

        Number(String n) {
            this.n = n;
        }

        @Override
        public int compareTo(Number o) {
            BigInteger a = new BigInteger(this.n + o.n);
            BigInteger b = new BigInteger(o.n + this.n);

            return b.compareTo(a);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Number> queue = new PriorityQueue<>();

        int max = 0;

        for (int i = 0 ; i < K ; i++) {
            String n = br.readLine();
            queue.offer(new Number(n));
            max = Math.max(max, Integer.parseInt(n));
        }

        while (K < N) {
            queue.offer(new Number(String.valueOf(max)));
            K++;
        }

        while(!queue.isEmpty()) {
            sb.append(queue.poll().n);
        }

        System.out.println(sb);

    }
}