import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger ans = new BigInteger(st.nextToken());
        ans = ans.add(new BigInteger(st.nextToken()));
        ans = ans.add(new BigInteger(st.nextToken()));
        
        System.out.println(ans);
    }
}
