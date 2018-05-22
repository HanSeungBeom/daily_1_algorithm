package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* exercise DFS and BFS
 * https://www.acmicpc.net/problem/1260
 * */

public class _180522 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc.nextInt();
      int V = sc.nextInt();
      
      Graph g = new Graph(N);
      
      //setting map
      for(int i=0;i<M;i++){
         int begin = sc.nextInt();
         int end = sc.nextInt();
         g.setEdge(begin, end);
      }
      
      System.out.println(g.startDFS(V));
      System.out.println(g.startBFS(V));
   }
   
   public static class Graph{
      private boolean[][] map;
      private boolean[] visit;
      private int n;
      
      public Graph(int n){
         this.n = n;
         map = new boolean[n+1][n+1];
      }
      
      public void setEdge(int i,int j){
         map[i][j] = true;
         map[j][i] = true;
      }
      
      public void initVisit(){
         visit = new boolean[n+1];
      }
      
      public String startDFS(int v){
         initVisit();
         String ans = DFS(v);
         return ans;
      }
      public String DFS(int v){
         String ans = v +" ";
         visit[v] = true;
         for(int i=1;i<=n;i++){
            if(map[v][i] && !visit[i])
               ans += DFS(i);
         }
         return ans;
      }
      public String startBFS(int v){
         
         StringBuffer sb = new StringBuffer();
         
         initVisit();
      
         Queue<Integer> queue = new LinkedList<>();
         queue.add(v);
         
         while(!queue.isEmpty()){
            int polled = queue.poll();
            if(!visit[polled]){
               visit[polled] = true;
               sb.append(polled+" ");
               for(int i=1;i<=n;i++){
                  if(!visit[i] && map[polled][i])
                     queue.add(i);
               }
            }
         }
         
         return sb.toString();
      }
   }

}