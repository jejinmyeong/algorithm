import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int [] arr =  new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int [] board = {'A', 0, 'B', 'C', 0, 'D', 0, 'E', 'F', 0, 'G', 0};

         for (int i = 0; i < 11; i++) {
             if (i == 1 || i == 4 || i == 6 || i == 9) continue;
             int now = i;
             boolean flag = true;

             for (int j = 0 ; j < N; j++) {
                 now += arr[j];
                 
                 while (now < 0) now += 12;
                 
                 now %= 12;

                 if (board[now] == 0) {
                     flag = false;
                     break;
                 }
             }

             if (flag) sb.append((char) board[i]).append(" ").append((char) board[now]).append("\n");
         }

        System.out.print(sb);
    }
}