import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int m = 1;
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= n; i++) {
            m *= i;
            m = m % 10;
        }

        System.out.println(m);
    }
}
