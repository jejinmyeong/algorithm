import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int e = str.length() - 2;

        sb.append("h");

        for (int i = 0 ; i < e * 2 ; i++) {
            sb.append("e");
        }

        sb.append("y");

        System.out.println(sb);
    }
}
