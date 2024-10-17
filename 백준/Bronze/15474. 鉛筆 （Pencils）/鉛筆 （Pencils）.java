import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int totalX = 0;
        int totalY = 0;

        if(n % a == 0) {
            totalX = (n / a) * b;
        }else {
            totalX = (n / a + 1) * b;
        }

        if(n % c == 0) {
            totalY = (n / c) * d;
        }else {
            totalY = (n / c + 1) * d;
        }

        if(totalX > totalY) {
            System.out.println(totalY);
        }else {
            System.out.println(totalX);
        }
    }
}
