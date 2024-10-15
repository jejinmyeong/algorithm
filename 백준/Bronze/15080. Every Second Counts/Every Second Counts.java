import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " : ");

        int h1 = Integer.parseInt(st.nextToken()) * 3600;
        int m1 = Integer.parseInt(st.nextToken()) * 60;
        int s1 = h1 + m1 + Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " : ");

        int h2 = Integer.parseInt(st.nextToken()) * 3600;
        int m2 = Integer.parseInt(st.nextToken()) * 60;
        int s2 = h2 + m2 + Integer.parseInt(st.nextToken());

        int res = s2 - s1;

        System.out.println(res > 0 ? res : res + 24 * 3600);
    }
}
