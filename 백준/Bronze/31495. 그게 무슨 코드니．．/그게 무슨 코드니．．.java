import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String answer = "";

        char start = str.charAt(0);
        char end = str.charAt(str.length()-1);

        if (start == '"' && end == '"' && str.length() <= 2) {
            answer = "CE";
        }else if(start == '"' && end == '"'){
            answer = str.substring(1, str.length()-1);
        }else{
            answer = "CE";
        }

        System.out.println(answer);
    }
}
