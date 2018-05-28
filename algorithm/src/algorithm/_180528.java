package algorithm;

import java.util.Scanner;

public class _180528 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int[] count = new int[26];
		
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if('a'<=c && c<='z')
				count[c-'a']++;
			else
				count[c-'A']++;
		}
		
		int max = -1;
		char ans = ' ';
		boolean hasSame = false;
		for(int i=0;i<26;i++){
			if(count[i]==max){
				hasSame = true;
			}
			else if(count[i]>max){
				max = count[i];
				hasSame = false;
				ans = (char)('A'+i);
			}
		}
		
		System.out.println(hasSame?"?":ans);
		
	}

}
