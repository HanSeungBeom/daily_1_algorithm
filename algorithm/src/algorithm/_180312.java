package algorithm;

import java.util.Scanner;


/*
 * what is problem :
 * Integer 4 can be expressed as a sum of 1s, 2s, and 3s in seven different ways as follows:
 * 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, and 3+1.
 * Write a program that determines the number of ways in which a given integer can be expressed as a sum of 1s, 2s, and 3s.
 * You may assume that the integer is positive and less than 11. 
 */

/*
 * how to solve :
 * I choose a dynamic programming because there are only three ways that is number is ended with 1s,2s,3s.
 * so I can make a recursion fomula like this. arr[i] = arr[i-1]+arr[i-2]+arr[i-3] 
 * */

/*
 * how to optimize : 
 * it is because the number that is given is less than 11, I pulled initialization and calculation content from out of for loop.
 * we can save unnecessary calculation from doing this.
 */

public class _180312 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++){
			int N = sc.nextInt();
			int arr[] = new int[11];
			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 4;
			
			for(int i=4;i<=N;i++){
				arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
			}
			System.out.println(arr[N]);
			
		}
	}
}
