import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Node_1753 implements Comparable<Node_1753>{
    int end, weight;
    public Node_1753(int end, int weight){
        this.end=end;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node_1753 o){
        return weight - o.weight;
    }
}
public class Dijkstra_1753 {
    static int V, E, K;
    static int[][] map;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;
    static boolean[] check;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st= new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        map = new int[V+1][V+1];
        dist = new int[V+1];
        check = new boolean[V+1];
        Arrays.fill(dist,INF);
        dist[K]=0;
        for(int i=0; i<E; i++){
            st= new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            map[from][to] = W;
        }

    }
    public static void Dijkstra(int start){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        check[start]=true;
        pq.add(start);
        dist[start]=0;
        for(int i =0; i<map[start].length; i++){
            if (map[start][i]>0){

            }
        }

    }

}
