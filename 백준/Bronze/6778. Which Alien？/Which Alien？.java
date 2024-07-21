import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Antena = Integer.parseInt(br.readLine());
        int eyes = Integer.parseInt(br.readLine());

        if (Antena >= 3 && eyes <= 4){
            System.out.println("TroyMartian");
        } if (Antena <= 6 && eyes >= 2){
            System.out.println("VladSaturnian");
        } if (Antena <=2 && eyes <= 3){
            System.out.println("GraemeMercurian");
        } else {

        }
    }
}