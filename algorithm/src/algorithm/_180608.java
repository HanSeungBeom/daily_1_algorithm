package algorithm;

import java.util.Arrays;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/2110
 */
public class _180608 {

	private static int N;
	private static int C;
	private static int[] arr;
	public static boolean isPossible(int value){
		int checked = 0;
		int lastChecked = 0;
		for(int i=0;i<N;i++){
			if(i == 0 || arr[i] - lastChecked>= value){
				lastChecked = arr[i];
				checked ++;
			}
		}
		if(checked>=C)
			return true;
		
		return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		C = sc.nextInt();
		arr = new int[N];
		
		for(int i=0;i<N;i++){
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int low = 1;
		int high = 10_0000_0001;
		int ans = -1;
		
		while(low<high){
			int mid = (int)((long)low+high)/2;
			if(isPossible(mid)){
				low = mid + 1;
				ans = mid;
			}
			else{
				high = mid;
			}
		}
		
		System.out.println(ans);
	}

}
