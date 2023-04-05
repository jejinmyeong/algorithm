import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String grade = br.readLine();
        
        if ("A+".equals(grade)){System.out.println("4.3");}
        else if ("A0".equals(grade)){System.out.println("4.0");}
        else if ("A-".equals(grade)){System.out.println("3.7");}
        else if ("B+".equals(grade)){System.out.println("3.3");}
        else if ("B0".equals(grade)){System.out.println("3.0");}
        else if ("B-".equals(grade)){System.out.println("2.7");}
        else if ("C+".equals(grade)){System.out.println("2.3");}
        else if ("C0".equals(grade)){System.out.println("2.0");}
        else if ("C-".equals(grade)){System.out.println("1.7");}
        else if ("D+".equals(grade)){System.out.println("1.3");}
        else if ("D0".equals(grade)){System.out.println("1.0");}
        else if ("D-".equals(grade)){System.out.println("0.7");}
        else if ("F".equals(grade)){System.out.println("0.0");}
    }
}