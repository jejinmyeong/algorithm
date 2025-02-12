import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String C = br.readLine();

        if ("M".equals(C)) System.out.println("MatKor");
        else if ("W".equals(C)) System.out.println("WiCys");
        else if ("C".equals(C)) System.out.println("CyKor");
        else if ("A".equals(C)) System.out.println("AlKor");
        else if ("$".equals(C)) System.out.println("$clear");
    }
}
