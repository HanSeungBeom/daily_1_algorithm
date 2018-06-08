package algorithm;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/10942
 */
public class _180609_dp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		
		for(int i=1;i<=N;i++)
			arr[i] = sc.nextInt();
		
		boolean[][] dp = new boolean[N+2][N+2];
		
		for(int j=1;j<=N;j++){
			for(int i=1;i<=N;i++){
				if(i==j) 
					dp[i][j] = true;
				else if(i+1==j)
					dp[i][j] = (arr[i]==arr[j]);
				else
					dp[i][j] = (dp[i+1][j-1]) && (arr[i]==arr[j]);
			}
		}
		
		
		int M = sc.nextInt();

		for(int i=0;i<M;i++){
			int s = sc.nextInt();
			int e = sc.nextInt();
			System.out.println(dp[s][e]?"1":"0");
		}
		
	}

}
