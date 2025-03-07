import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        String[] bssArr = new String[1500];
        String[] bss = new String[] {"bowling", "swimming", "soccer"};
        for (int i = 0; i < 1500; i++) {
            bssArr[i] = bss[(int)(Math.random()*3)];
        }

        System.out.println();
        System.out.println(String.join(" ", bssArr));
        System.out.flush();


        String bss2 = br.readLine();
        String[] bssArr2 = bss2.split(" ");
        String[] bssArr3 = new String[1500];
        
        for (int i = 0; i < 1500; i++) {
            if (bssArr[i].equals("bowling")) {
                if (bssArr2[i].equals("swimming")) {
                    bssArr3[i] = "soccer";
                } else {
                    bssArr3[i] = "swimming";
                }
            } else if (bssArr[i].equals("swimming")) {
                if (bssArr2[i].equals("bowling")) {
                    bssArr3[i] = "soccer";
                } else {
                    bssArr3[i] = "bowling";
                }
            } else {
                if (bssArr2[i].equals("bowling")) {
                    bssArr3[i] = "swimming";
                } else {
                    bssArr3[i] = "bowling";
                }
            }
        }

        System.out.println();
        System.out.println(String.join(" ", bssArr3));
        System.out.flush();
    }
}

