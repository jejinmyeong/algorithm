import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringBuilder [] sbs = new StringBuilder[15];

        for (int i = 0 ; i < 15 ; i++) {
            sbs[i] = new StringBuilder();
        }

        for (int i = 0 ; i < 5 ; i++) {
            char [] input = br.readLine().toCharArray();

            for (int j = 0 ; j < input.length ; j++) {
                sbs[j].append(input[j]);
            }
        }

        for (int i = 0 ; i < 15 ; i++) {
            sb.append(sbs[i]);
        }

        System.out.println(sb);

    }
}