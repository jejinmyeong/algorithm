import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int D = 0;
        int P = 0;

        for (int i = 0 ; i < N ; i++) {
            if ("D".equals(br.readLine())) {
                D++;
            } else {
                P++;
            }
            
            if (Math.abs(D - P) >= 2) {
                break;
            }
        }

        System.out.println(D + ":" + P);
    }
}