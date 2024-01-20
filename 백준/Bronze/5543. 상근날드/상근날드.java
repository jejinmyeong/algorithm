import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int bugger = Integer.MAX_VALUE;

        for (int i = 0 ; i < 3 ; i++) {
            bugger = Math.min(bugger, Integer.parseInt(br.readLine()));
        }

        int drink = Integer.MAX_VALUE;

        for (int i = 0 ; i < 2 ; i++) {
            drink = Math.min(drink, Integer.parseInt(br.readLine()));
        }

        System.out.println(bugger + drink - 50);
    }
}