package algorithm;

/* review for merge sort (top-down) */
/* Time Complexity : O(nlogn) */
class MergeSort{

	private int[] arr;
	private int[] temp;
	public MergeSort(int[] arr){
		this.arr = arr;
		temp = new int[arr.length];
		
		for(int i=0;i<arr.length;i++)
			temp[i] = arr[i];
	}
	public void topDownSort(int start, int end){
		if(end - start<1)
			return;
		
		int middle = (start + end)/2;
		topDownSort(start,middle);
		topDownSort(middle+1,end);
		merge(start,middle,end);
	}
	
	public void bottomUpSort(int start, int end){
		int totalLen = end - start +1;
	
		for(int width = 1; width < totalLen; width *=2){
			for(int i=start;i<=end; i+=2*width){
				int mergeStart = i;
				int mergeEnd = i+2*width-1;
				int mid = (mergeStart + mergeEnd)/2;
				merge(mergeStart,mid,Math.min(mergeEnd, end));
			}
		}
		
	}
	
	public void merge(int start,int mid,int end){
		int i = start;
		int j = mid +1;
		int pos = i;
		
		while(!(pos>end)){
			if(i>mid){
				arr[pos++] = temp[j++];
			}
			else if(j>end){
				arr[pos++] = temp[i++];
			}
			else{
				if(temp[i]>temp[j])
					arr[pos++] = temp[j++];
				else
					arr[pos++] = temp[i++];
			}
		}
		
		for(int k=start;k<=end;k++)
			temp[k] = arr[k];
	}
	

	public void print(){
		for(int e: arr){
			System.out.print(e+" ");
		}
		System.out.println("");
	}
	
}
public class _180511 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,-10,100,100,50,-1000};
		MergeSort ms = new MergeSort(arr);
		ms.bottomUpSort(0,arr.length-1);
		ms.print();
	}
}
