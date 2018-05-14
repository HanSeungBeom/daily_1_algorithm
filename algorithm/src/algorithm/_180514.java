package algorithm;


/* review for quick sort (top-down) */
/* Time Complexity : O(nlogn) */
class QuickSort{

	private int[] arr;
	public QuickSort(int[] arr){
		this.arr = arr;
	}
	public void sort(int start, int end){
		
		if(start >= end) {
			System.out.println("return");
		}
		//set pivot
		int pivot = end;
		int firstBigOne = start;

		//change array with pivot	
		for(int i=start;i<end;i++){
			if(arr[i]>=arr[pivot]){
				continue;
			}
			else{
				swap(firstBigOne++,i);
			}
		}
		swap(firstBigOne,pivot);
		
		pivot = firstBigOne;

		//reculsion
		sort(start,pivot-1);
		sort(pivot+1,end);
	}
	
	public void swap(int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	

	

	public void print(){
		for(int e: arr){
			System.out.print(e+" ");
		}
		System.out.println("");
	}
	
}
public class _180514 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1,-10,100,500,-50,-1000};
		
		QuickSort ms = new QuickSort(arr);
		ms.sort(0,arr.length-1);
		ms.print();
	}
}