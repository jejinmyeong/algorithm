import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if(b == c && b != a) {
            System.out.println("A");
        }else if(a == c && a != b) {
            System.out.println("B");
        }else if(a == b && a != c) {
            System.out.println("C");
        }else {
            System.out.println("*");
        }
    }
}
