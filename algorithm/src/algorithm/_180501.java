package algorithm;

import java.util.Arrays;
import java.util.Scanner;

/* there are N integers input.
 * 1. sort them with ascending order.
 * 2. print the result of ( a1-a2+a3-a4+...+a(2i-1)-a(2i) )
 * 3. 1<=N<=10000, 0<=ai<=10,000,000
 * 
 * */

public class _180501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		final int T = sc.nextInt();
		
		for(int t=1;t<=T;t++){
			final int N = sc.nextInt();
			int[] num = new int[N];
			
			for(int i=0;i<N;i++)
				num[i] = sc.nextInt();
			
			Arrays.sort(num);
			
			/* The variable "ans" is long data type 
			 * to prevent overflow because a_i is from 0 to 10,000,000  */
			long ans = 0;
		
			for(int i=0;i<N-1;i+=2)
				ans += (num[i]-num[i+1]);
			
			/* when N is odd, sum the last element. */
			if(N%2 != 0) 
				ans += num[N-1];
			
			System.out.println("Case #"+t);
			System.out.println(ans);
		}
		
	}

}
