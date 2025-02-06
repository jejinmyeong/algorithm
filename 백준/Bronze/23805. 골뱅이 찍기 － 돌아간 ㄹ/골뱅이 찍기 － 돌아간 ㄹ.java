import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < 5 ; i++) {
            for (int j = 0 ; j < N ; j++) {
                for (int k = 0 ; k < 5 ; k++) {
                    for (int l = 0 ; l < N ; l++) {
                        if (i == 0) {
                            if (k == 3) sb.append(" ");
                            else sb.append("@");
                        } else if (i == 4) {
                            if (k == 1) sb.append(" ");
                            else sb.append("@");
                        } else {
                            if (k == 1 || k == 3) sb.append(" ");
                            else sb.append("@");
                        }
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
