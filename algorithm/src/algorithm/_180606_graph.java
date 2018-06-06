package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/1939
 * */
public class _180606_graph {

	private static int n;
	private static int m;
	private static int[][] map;
	
	public static boolean isPossible(long weight, int begin, int end){
		boolean[] visit = new boolean[n+1];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(begin);
		
		while(!queue.isEmpty()){
			int node = queue.poll();
			
			if(visit[node]) 
				continue;
			
			visit[node] = true;
			
			if(node == end){
				return true;
			}
			
			for(int i=1;i<=n;i++){
				if(i == node) 
					continue;
				
				if(map[node][i]!=0 && map[node][i]>=weight){
					queue.add(i);
				}
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n+1][n+1];
		
		for(int i=0;i<m;i++){
			int begin = sc.nextInt();
			int end = sc.nextInt();
			int value = sc.nextInt();
			map[begin][end] = value;
			map[end][begin] = value;
		}
		
		int startNode = sc.nextInt();
		int endNode = sc.nextInt();
		
		long low = 1;
		long high = 1_000_000_001;
		
		long lastSuccess = 1;
		while(low<high){
			long mid = (low+high)/2;
			if(isPossible(mid, startNode, endNode)){
				lastSuccess = mid;
				low = mid+1;
			}
			else{
				high = mid;
			}
		}
		
		System.out.println(lastSuccess);		
	}

}
