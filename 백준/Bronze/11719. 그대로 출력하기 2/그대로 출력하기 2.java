import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        
        String input;
        while((input = br.readLine()) != null) {
            sb.append(input).append("\n");
        }

        System.out.print(sb);
    }
}
