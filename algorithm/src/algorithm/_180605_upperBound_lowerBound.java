package algorithm;

import java.util.Arrays;
import java.util.Scanner;

/* https://www.acmicpc.net/problem/10816
 * timeComplexity : O(MlogN)
 */

public class _180605_upperBound_lowerBound {

    public static int upperBound(int[] array, int value) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value > array[mid]) {
                low = mid + 1;
            }else if(value == array[mid]){
            	low = mid + 1;
            }
            else {// value < array[mid]
                high = mid;
            }
        }
        if(low != 0 && array[low-1] == value) return low-1;
        else return -1;
 
    }
    public static int lowerBound(int[] array, int value) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value > array[mid]) {
            	low = mid + 1;
            } else if(value == array[mid]){
            	high = mid;
            } else { //value < array[mid]
                high = mid;
            }
        }
        if(low != array.length && array[low] == value) return low;
        else return -1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++){
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<M;i++){
			int target = sc.nextInt();
			int lowerIndex = lowerBound(arr, target);
			int upperIndex = upperBound(arr, target);
			
			int count = 0;
			if(!(lowerIndex == -1||upperIndex == -1)) 
				count = upperIndex - lowerIndex + 1;
			
			sb.append(count+" ");
		}
		
		System.out.println(sb.toString());
		
	}

}
