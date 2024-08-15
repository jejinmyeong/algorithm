import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String K = br.readLine();

        int odd = 0;
        int even = 0;

        for (int i = 0 ; i < N ; i++) {
            if ((K.charAt(i) - '0') % 2 == 0) even++;
            else odd++;
        }

        if (odd < even) System.out.println(0);
        else if (odd > even) System.out.println(1);
        else System.out.println(-1);

    }
}
