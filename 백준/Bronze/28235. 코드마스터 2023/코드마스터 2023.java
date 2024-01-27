import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        if ("SONGDO".equals(input)) System.out.println("HIGHSCHOOL");
        else if ("CODE".equals(input)) System.out.println("MASTER");
        else if ("2023".equals(input)) System.out.println("0611");
        else if ("ALGORITHM".equals(input)) System.out.println("CONTEST");

    }
}