import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        if (Integer.parseInt(br.readLine()) == 0) {
            System.out.println("YONSEI");
        } else {
            System.out.println("Leading the Way to the Future");
        }
    }
}