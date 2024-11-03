import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int testNum = Integer.parseInt(br.readLine());
            if (testNum % 2 == 0) {
                System.out.println(testNum + " is even");
            }
            else {
                System.out.println(testNum + " is odd");
            }
        }
    }
}
