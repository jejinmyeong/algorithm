import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        double v = Math.pow(D, 2) / (Math.pow(H, 2) + Math.pow(W, 2));

        double h = v * Math.pow(H, 2);
        double w = v * Math.pow(W, 2);

        System.out.println((int) Math.sqrt(h) + " " + (int) Math.sqrt(w));
    }
}
