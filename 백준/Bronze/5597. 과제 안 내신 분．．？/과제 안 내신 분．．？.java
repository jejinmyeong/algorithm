import java.util.*;
import java.io.*;

public class Main {
    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        boolean [] visited = new boolean[31];
        
        for (int i = 0 ; i < 28 ; i++) {
            int s = Integer.parseInt(br.readLine());
            visited[s] = true;
        }
        
        for (int i = 1 ; i <= 30 ; i++) {
            if (!visited[i]) sb.append(i).append("\n");
        }
        
        System.out.print(sb);
    }
}