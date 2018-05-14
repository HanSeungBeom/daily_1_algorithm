package algorithm;

/* review for quick sort (top-down) */
/* Time Complexity : O(nlogn) */
class QuickSort{

	private int[] arr;
	public QuickSort(int[] arr){
		this.arr = arr;
	}
	public void sort(int begin, int end){
		int pivot = arr[(begin+end)/2];
		int l = begin;
		int r = end;

		do{
			while(arr[l]<pivot)l++;
			while(arr[r]>pivot)r--;
			if(l<=r){
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				l++;
				r--;
			}
		}while(l<=r);
		
		if(l<end)sort(l,end);
		if(begin<r)sort(begin,r);
	}
	
	public void print(){
		for(int e: arr){
			System.out.print(e+" ");
		}
		System.out.println("");
	}
	
}
public class _180514_QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1,2,7,-100,50,2};
		
		QuickSort ms = new QuickSort(arr);
		ms.sort(0,arr.length-1);
		ms.print();
	}
}