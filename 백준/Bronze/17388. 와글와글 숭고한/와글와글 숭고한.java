import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        if (S + K + H >= 100) {
            System.out.println("OK");
        } else {
            if (S < Math.min(K, H)) {
                System.out.println("Soongsil");
            } else if (K < Math.min(S, H)) {
                System.out.println("Korea");
            } else {
                System.out.println("Hanyang");
            }
        }
    }
}