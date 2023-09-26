import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int money = Integer.parseInt(st.nextToken()) * 100;
        int choco = Integer.parseInt(st.nextToken());

        if (money < choco) System.out.println("No");
        else System.out.println("Yes");
    }
}
