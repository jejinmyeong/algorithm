import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int amount = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < 9 ; i++) {
            amount -= Integer.parseInt(br.readLine());
        }

        System.out.println(amount);
    }
}