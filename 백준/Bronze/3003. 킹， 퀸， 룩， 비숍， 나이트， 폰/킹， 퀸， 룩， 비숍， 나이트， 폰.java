import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        //1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8
        
        int [] chess = new int [] {1, 1, 2, 2, 2, 8};
        
        for (int i = 0 ; i < 6 ; i++) {
            sb.append(chess[i] - Integer.parseInt(st.nextToken())).append(" ");
        }
        
        System.out.println(sb);
    }
}