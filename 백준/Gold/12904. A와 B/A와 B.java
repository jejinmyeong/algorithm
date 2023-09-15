import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder str = new StringBuilder(br.readLine());
        StringBuilder target = new StringBuilder(br.readLine());

        while(str.length() < target.length()) {
            if (target.charAt(target.length() - 1) == 'A') {
                target.deleteCharAt(target.length() - 1);
            } else {
                target.deleteCharAt(target.length() - 1);
                target.reverse();
            }
        }

        if (str.toString().contentEquals(target)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}