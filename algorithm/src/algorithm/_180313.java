package algorithm;

import java.util.Scanner;

// problem: https://www.acmicpc.net/problem/2903

/* 1. how to solve 
 * the first thing I was going to do was to find a new squares that is created after iteration.
 * I found out it was easy to find how many squares will be created after iteration, 
 * but that was not good way because I must consider overlapping points to count dots from that squares. 
 * so, I changed my way to count the number of dots on side because I found out that the number of dots on both side is same.
 * 
 * and I found the relationship between the number of side's point at the N iteration and the previous number.
 * length(N) = 2 * length(N-1) - 1
 * 
 */

// 2. coding
public class _180313 {

	public static final int INPUT_MAX = 18;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		int len[] = new int[INPUT_MAX];
		int input = sc.nextInt();
		len[0] = 2;
		
		for(int i=1;i<=input;i++){
			len[i] = (len[i-1]-1)*2+1;
		}
		
		
		int ans = len[input]*len[input];
		System.out.println(ans);
	}

}

/* 3. optimize
 *  because we don't need values after input interation, for loop is from 1 to input. 
 */
