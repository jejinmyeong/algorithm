import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int X = Integer.parseInt(br.readLine());
        int Y = Integer.parseInt(br.readLine());
        int Z = Integer.parseInt(br.readLine());
        
        if (X + Y > Z) System.out.println(0);
        else System.out.println(1);
    }
}
