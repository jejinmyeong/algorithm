import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;

        for (int i = 0 ; i < 6 ; i++) {
            String p = br.readLine();

            if ("W".equals(p)) ans++;
        }

        if (ans > 4) System.out.println(1);
        else if (ans > 2) System.out.println(2);
        else if (ans > 0) System.out.println(3);
        else System.out.println(-1);
    }
}