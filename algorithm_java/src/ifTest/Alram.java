package ifTest;

import java.util.*;

public class Alram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h, m;
		
		h = sc.nextInt();
		m = sc.nextInt();
		
		if(m<45) {
			m = m-45+60;
			h -= 1;
			if (h<0) h+=24;
		}else {
			m -= 45;
		}
		
		System.out.println(h+" "+m);
	}
}
