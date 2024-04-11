import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        int ball = 1;

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            if (ball == X) {
                ball = Y;
            } else if (ball == Y) {
                ball = X;
            }
        }

        System.out.println(ball);
    }
}
