import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int [] visited = new int[10];

        for (int i = 0 ; i < input.length() ; i++) {
            int now = input.charAt(i) - '0';

            if (now == 6 || now == 9) {
                if (visited[6] > visited[9]) visited[9]++;
                else visited[6]++;
            } else {
                visited[now]++;
            }
        }

        int max = 0;

        for (int i = 0 ; i < 10 ; i++) {
            max = Math.max(visited[i], max);
        }

        System.out.println(max);

    }
}