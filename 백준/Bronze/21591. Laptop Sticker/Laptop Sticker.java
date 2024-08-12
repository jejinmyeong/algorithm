import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int wc = Integer.parseInt(st.nextToken());
        int hc = Integer.parseInt(st.nextToken());
        
        int ws = Integer.parseInt(st.nextToken());
        int hs = Integer.parseInt(st.nextToken());
        
        if (ws <= wc - 2 && hs <= hc - 2) System.out.println(1);
        else System.out.println(0);
    }
}
