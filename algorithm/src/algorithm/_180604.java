package algorithm;

import java.util.Scanner;

public class _180604 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] count = new int[10];
		
		String numberStr = sc.nextLine();
		for(int i=0;i<numberStr.length();i++){
			int num = Integer.parseInt(numberStr.charAt(i)+"");
			count[num]++;
		}
		
		int sixAndNine = (int)Math.round(((double)count[6]+count[9])/2);

		int max = -1;
		for(int i=0;i<10;i++){
			if(i == 6 || i == 9)
				continue;
			
			if(count[i]>max)
				max = count[i];
		}
		
		System.out.println(Math.max(max, sixAndNine));
		
	}

}
