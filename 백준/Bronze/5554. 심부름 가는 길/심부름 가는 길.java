import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sec = 0;

        for (int i = 0 ; i < 4 ; i++) {
            sec += Integer.parseInt(br.readLine());
        }

        sb.append(sec / 60).append("\n");
        sb.append(sec % 60);

        System.out.println(sb);
    }
}