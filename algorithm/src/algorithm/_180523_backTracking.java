package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author hanseungbeom
 * @category backtracking
 * @problem https://www.acmicpc.net/problem/1697
 */

public class _180523_backTracking {

	public static class Pair{
		int pos;
		int time;
		public Pair(){
			
		}
		public Pair(int pos,int time){
			this.pos = pos;
			this.time = time;
		}
		public int getPos() {
			return pos;
		}
		public void setPos(int pos) {
			this.pos = pos;
		}
		public int getTime() {
			return time;
		}
		public void setTime(int time) {
			this.time = time;
		}
		
	}
	
	public static int find(int from, int to){
		boolean[] visited = new boolean[100001];
	    Queue<Pair> queue = new LinkedList<>();
	    int ans = 0;
	    
	    queue.add(new Pair(from,0));
	   
	    while(!queue.isEmpty()){
	    	Pair picked = queue.poll();
	    	int pos = picked.pos;
	    	int time = picked.time;
	    	
	    	if(pos <0 || pos > 100000) continue;
	    	if(visited[pos]) continue;

	    	visited[pos] = true;
	    	if(pos == to){
	    		ans = time;
	    		break;
	    	}
	    
	    	queue.add(new Pair(pos+1,time+1));
	    	queue.add(new Pair(pos-1,time+1));
	    	queue.add(new Pair(pos*2,time+1));
	    }
	    return ans;
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int ans = find(n,k);
	
		System.out.println(ans);
	}


}
