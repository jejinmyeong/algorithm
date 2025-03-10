import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int t1 = Integer.parseInt(st.nextToken()), e1 = Integer.parseInt(st.nextToken()), f1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int t2 = Integer.parseInt(st.nextToken()), e2 = Integer.parseInt(st.nextToken()), f2 = Integer.parseInt(st.nextToken());

        int max = t1 * 3 + e1 * 20 + f1 * 120;
        int mel = t2 * 3 + e2 * 20 + f2 * 120;

        if (max < mel) {
            System.out.println("Mel");
        } else if (max > mel) {
            System.out.println("Max");
        } else {
            System.out.println("Draw");
        }
    }
}
