import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        
        int len = str.length();
        int colone = 0;
        int underbar = 0;
        
        for (int i = 0 ; i < len ; i++) {
            char c = str.charAt(i);
            
            if (c == ':') colone++;
            else if (c == '_') underbar++;
        }

        System.out.println(len + colone + underbar * 5);
    }
}
