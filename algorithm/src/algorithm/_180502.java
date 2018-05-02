package algorithm;

import java.util.Scanner;
import java.util.Stack;

/* codeground Practice #57
 * this is problem about Stack.
 * goal is to find the longest perfect bracket 
 * 
 * rules
 * 1. ' ' is perfect bracket
 * 2. if S1 is a perfect bracket , then [S1], {S1}, (S1) are also perfect bracket.
 * 3. if S1,S2 are perfect bracket, then S1S2 is a perfect bracket.
 * 
 * Time complexity of my algorithm is O(N).
 * */

public class _180502 {
	
	public static char getPair(char c){
		if(c == '}') return '{';
		else if( c == ')') return '(';
		else return '[';
	}
	public static boolean isOpeningBracket(char c){
		if(c == '{' || c == '(' || c=='[')
			return true;
		else 
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		
		int T = Integer.parseInt(sc.nextLine());
		for(int testCase=1; testCase<=T;testCase++){
			Stack<Character> stack = new Stack<>();
			
			String str = sc.nextLine();
			
			int ans = 0;
			
			int possiblity = 0;
			int linkedBracket = 0;
			int biggestLinkedBracket = 0;
			
			for(int i=0;i<str.length();i++){
				
				char now = str.charAt(i);
						
				if(isOpeningBracket(now)){
					stack.push(now);
					linkedBracket = 0;
					continue;
				}
				
				if(now == ' ') {
					linkedBracket++;
					biggestLinkedBracket = Math.max(biggestLinkedBracket,linkedBracket);
					
					possiblity++;
					continue;
				}
				
				if(!stack.isEmpty()){
					char popElement = stack.peek();

					if( getPair(now) == popElement){
						stack.pop();
						linkedBracket += 2;
						biggestLinkedBracket = Math.max(biggestLinkedBracket,linkedBracket);
						
						possiblity += 2;		
						if(stack.isEmpty())
							ans = Math.max(ans, possiblity);
					}
					else{
						stack.clear();
						possiblity = 0;
						linkedBracket = 0;
					}
				}
				else{
					stack.clear();
					possiblity = 0;
				}	
			}
			
			ans = Math.max(ans, biggestLinkedBracket);
			
			System.out.println("Case #"+testCase);
			System.out.println(ans);
		}
	}
}
