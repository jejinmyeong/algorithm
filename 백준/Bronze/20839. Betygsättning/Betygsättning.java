import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (x <= a && y <= b && z <= c) System.out.println("A");
        else if ((double)x / 2 <= a && y <= b && z <= c) System.out.println("B");
        else if (y <= b && z <= c) System.out.println("C");
        else if ((double)y / 2 <= b && z <= c) System.out.println("D");
        else if (z <= c) System.out.println("E");

    }
}
