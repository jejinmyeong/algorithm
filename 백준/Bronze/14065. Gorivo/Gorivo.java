import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        final double GALON = 3.785411784;
        final double MILE = 1.609344;
        
        double n = Double.parseDouble(br.readLine());

        System.out.println(100 / (MILE / GALON * n));
    }
}