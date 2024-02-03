import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        boolean win = false;
        int team1 = 0;
        int team2 = 0;

        for (int i = 0 ; i < 9 ; i++) {
            team1 += Integer.parseInt(st1.nextToken());
            if (team1 > team2) {
                win = true;
            }
            team2 += Integer.parseInt(st2.nextToken());
        }

        if (team1 < team2 && win) System.out.println("Yes");
        else System.out.println("No");
    }
}