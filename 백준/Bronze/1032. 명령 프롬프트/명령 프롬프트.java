import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String [] arr = new String[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0 ; i < arr[0].length() ; i++) {
            boolean flag = true;
            for (int j = 1 ; j < N ; j++) {
                if (arr[0].charAt(i) != arr[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                sb.append(arr[0].charAt(i));
            } else {
                sb.append("?");
            }
        }

        System.out.println(sb);
    }
}
