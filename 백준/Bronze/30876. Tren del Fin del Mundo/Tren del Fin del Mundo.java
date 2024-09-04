import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int minA = Integer.MAX_VALUE;
        int minB = Integer.MAX_VALUE;

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (minB > b) {
                minB = b;
                minA = a;
            }
        }

        System.out.println(minA + " " + minB);
    }
}
