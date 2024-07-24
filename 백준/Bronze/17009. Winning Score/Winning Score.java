import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int [] arr = new int[6];
        
        for (int i = 0 ; i < 6 ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int A = arr[0] * 3 + arr[1] * 2 + arr[2];
        int B = arr[3] * 3 + arr[4] * 2 + arr[5];
        
        if (A == B) System.out.println("T");
        else if (A > B) System.out.println("A");
        else System.out.println("B");
    }
}