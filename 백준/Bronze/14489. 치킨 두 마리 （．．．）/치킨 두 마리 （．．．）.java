import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long C = Long.parseLong(br.readLine());

        if (A + B >= C * 2) {
            System.out.println(A + B - C * 2);
        } else {
            System.out.println(A + B);
        }
    }
}