import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(fact(1, N));
    }

    static BigInteger fact(int a,int n){
        BigInteger ret=BigInteger.valueOf(a);

        if(a<n){
            int b=(a+n)/2;
            ret=fact(a,b).multiply(fact(b+1,n)); //두개로 나눠서 a풀이
        }
        return ret;
    }
}
