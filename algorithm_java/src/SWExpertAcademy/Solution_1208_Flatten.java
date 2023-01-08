package SWExpertAcademy;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1208_Flatten {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <=T; test_case++) {
			int dump = sc.nextInt();
			int [] boxs = new int[100];
			
			
			for(int i = 0 ; i<100;i++) {
				boxs[i] = sc.nextInt();	
			}
			
			Arrays.sort(boxs);
			
			for(int i = 0; i<dump;i++) {
				for(int j = 0;j<100;j++) {
					if(boxs[j] != boxs[j+1]) {
						boxs[j]++;
						break;
					}
				}
				for(int j = 99;j>0;j--) {
					if(boxs[j] != boxs[j-1]) {
						boxs[j]--;
						break;
					}
				}
			}
			System.out.println("#"+test_case+" "+(boxs[99]-boxs[0]));
			
			
		}
		sc.close();
	}

}
