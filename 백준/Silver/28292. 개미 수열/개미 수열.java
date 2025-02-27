import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N < 3) {
            System.out.println(1);
        } else if (N < 6) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }
}