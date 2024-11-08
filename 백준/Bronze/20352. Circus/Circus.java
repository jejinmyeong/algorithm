import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigDecimal tentArea = new BigDecimal(br.readLine());

        double tentPerimeter = tentArea
                .multiply(BigDecimal.valueOf(Math.PI))
                .multiply(BigDecimal.valueOf(4))
                .sqrt(new MathContext(12)).doubleValue();

        System.out.println(tentPerimeter);
    }
}
