import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        
        int futureDay = A + (B * 7);
        
        if (futureDay >= 1 && futureDay <= 30) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
