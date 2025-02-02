import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (x != 0 && y != 0) {
            System.out.println(2);
        } else if (x == 0) {
            if (a != x || a == x && y < b) {
                System.out.println(1);
            } else {
                System.out.println(3);
            }
        } else {
            if (b != y || b == y && x < a) {
                System.out.println(1);
            } else  {
                System.out.println(3);
            }
        }
    }
}
