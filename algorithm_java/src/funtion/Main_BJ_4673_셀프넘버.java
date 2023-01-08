package funtion;

public class Main_BJ_4673_셀프넘버 {
	
	
	public static void main(String[] args) {
		String str = String.valueOf(1234);
		StringBuilder sb = new StringBuilder();
		
		int [] check = new int [10001];
				
		for (int i = 1 ; i < 10001 ; i++) {
			String s = String.valueOf(i);
			int num = i;
			for (int j = 0 ; j < s.length() ; j++) {
				num += s.charAt(j) -'0';
			}
			if (num <= 10000) {
				check[num]++;
			}
		}
		
		for (int i = 1 ; i < 10001 ; i++) {
			if (check[i] == 0) sb.append(i+"\n");
		}
		System.out.println(sb);
		
	}
}
