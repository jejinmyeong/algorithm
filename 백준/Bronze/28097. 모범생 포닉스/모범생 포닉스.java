import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int time = -8;

        for (int i = 0 ; i < N ; i++) {
            time += 8;
            time += Integer.parseInt(st.nextToken());
        }

        System.out.println(time / 24 + " " + time % 24);
    }
}