import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS_list {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringTokenizer st1;
        st1= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int v = Integer.parseInt(st1.nextToken());

        boolean visited[] = new boolean[n+1];
        LinkedList<Integer>[] li = new LinkedList[n+1];

        for(int i=0; i<=n; i++){
            li[i]= new LinkedList<Integer>();
        }
        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int v1 =Integer.parseInt(st.nextToken());
            int v2 =Integer.parseInt(st.nextToken());
            li[v1].add(v2);
            li[v2].add(v1);
        }
        for(int i=1; i<=n; i++){
            Collections.sort(li[i]);
//            System.out.println(li[i]);
        }
        bfs_list(v, li, visited);
    }
    //BFS -인접행렬
   public static void bfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited ){
        Queue<Integer> q = new LinkedList<Integer>();
        visited[v] = true;
        q.add(v);
        while(q.size()!=0){
            v=q.poll();

            System.out.print(v+" ");
            Iterator<Integer> iter = adjList[v].iterator();
            while(iter.hasNext()){
                int w = iter.next();
                if(!visited[w]){
                    visited[w]=true;
                    q.add(w);
                }
            }

        }
    }
}
