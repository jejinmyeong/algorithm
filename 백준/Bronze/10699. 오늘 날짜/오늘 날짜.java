import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

        TimeZone tz = TimeZone.getTimeZone("GMT");

        date.setTimeZone(tz);

        System.out.println(date.format(new Date()));
    }
}