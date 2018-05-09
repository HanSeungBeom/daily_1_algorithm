package algorithm;

import java.util.Arrays;
import java.util.Scanner;

/* codeground Practice #45
 * T is test case
 * M is the possible credits you can register for this semester
 * N is the number of classes opening this semester.
 * The problem is to get the most credit you can register for semester.
 *
 * Time complexity of my algorithm is O(NM)
 * */

public class _180509 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase<=T; testCase++){
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] credit = new int[N+1];
			
			for(int i=1;i<=N;i++)
				credit[i] = sc.nextInt();
			
			Arrays.sort(credit);
			
			int[] dp = new int[M+1];
			/* dp[i] : when M is i, the largest possible credits you can here.
			 */
			
			for(int j=1;j<=M;j++){
				for(int i=1;i<=N;i++){
					if(j - credit[i]<0) continue;
				    dp[j] = Math.max(dp[j], dp[j - credit[i]] + credit[i]);
				}
			}
			
			System.out.println("Case #"+testCase);
			System.out.println(dp[M]);
			
		}
	}

}
