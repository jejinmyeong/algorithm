import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(11);
            System.out.println("A B C D E F G H J L M");
        } else if (n == 2 || n == 3) {
            System.out.println(9);
            System.out.println("A C E F G H I L M");
        } else if (n == 4) {
            System.out.println(9);
            System.out.println("A B C E F G H L M");
        } else if (n == 5 || n == 6 || n == 7 || n == 8 || n == 9) {
            System.out.println(8);
            System.out.println("A C E F G H L M");
        } else {
            System.out.println(8);
            System.out.println("A B C F G H L M");
        }
    }
}

