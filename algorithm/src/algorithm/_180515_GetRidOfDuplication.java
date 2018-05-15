package algorithm;

import java.util.HashMap;
import java.util.Scanner;


/* Time complexity is O(N) */

public class _180515_GetRidOfDuplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine();
		HashMap<Character, Boolean> hashmap = new HashMap<>();
		StringBuffer ans = new StringBuffer();
		
		for(int i=0;i<inputStr.length();i++){
			char c = inputStr.charAt(i);
			
			if(hashmap.containsKey(c))
				continue;
			
			hashmap.put(c, true);
			ans.append(c);
		}
		
		System.out.println(ans);
	}

}
