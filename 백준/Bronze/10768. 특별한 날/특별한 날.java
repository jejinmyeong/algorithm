import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int m = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        
        if (m == 2 && d == 18) {
            System.out.println("Special");
        } else if (m >= 3 || (m == 2 && d > 18)) {
            System.out.println("After");
        } else {
            System.out.println("Before");
        }
    }
}