import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a1 = Integer.parseInt(br.readLine());
        int a2 = Integer.parseInt(br.readLine());
        int a3 = Integer.parseInt(br.readLine());

        int res = Math.min(a2 * 2 + a3 * 4, Math.min(a1 * 2 + a3 * 2, a1 * 4 + a2 * 2));

        System.out.println(res);
    }
}
