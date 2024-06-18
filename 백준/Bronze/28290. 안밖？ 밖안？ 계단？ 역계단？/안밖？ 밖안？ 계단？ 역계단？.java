import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        if ("fdsajkl;".equals(str) || "jkl;fdsa".equals(str)) System.out.println("in-out");
        else if ("asdf;lkj".equals(str) || ";lkjasdf".equals(str)) System.out.println("out-in");
        else if ("asdfjkl;".equals(str)) System.out.println("stairs");
        else if (";lkjfdsa".equals(str)) System.out.println("reverse");
        else System.out.println("molu");
    }
}