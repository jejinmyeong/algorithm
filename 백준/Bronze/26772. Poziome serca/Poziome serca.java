import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String [] heart = {
            " @@@   @@@  ",
            "@   @ @   @ ",
            "@    @    @ ",
            "@         @ ",
            " @       @  ",
            "  @     @   ",
            "   @   @    ",
            "    @ @     ",
            "     @      "
        };

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < heart.length ; i++) {
            for (int j = 0 ; j < N ; j++) {
                sb.append(heart[i]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
