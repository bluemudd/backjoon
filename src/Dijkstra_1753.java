import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Node implements Comparable<Node>{
    int end, weight;
    public Node(int end, int weight){
        this.end=end;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o){
        return weight - o.weight;
    }
}
public class Dijkstra_1753 {
    private static final int INF = 100_000_000;
    static int V, E, K;
    static List<Node>[] list;
    static int[] dist; // int 배열로 출발지에서 최소거리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); //정점
        E = Integer.parseInt(st.nextToken()); //간선
        K = Integer.parseInt(br.readLine());  //정점 번호
        list= new ArrayList[V+1];
        dist = new int[V+1];
        Arrays.fill(dist, INF);
        for(int i =1; i<=V; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i<E; i++){
            st= new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,c));
        }
        dijkstra(1);
    }
    private static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[V+1];
        queue.add(new Node(start,0));
        dist[start]= 0;
        while(!queue.isEmpty()){
            for(int i=0; i<dist.length; i++){
                System.out.print("["+dist[i]+"] ");
            }
            System.out.println("");
            Node curNode = queue.poll();
            int cur = curNode.end;
            if(check[cur] ==true) continue;
            check[cur] = true;
            for(Node node : list[cur]){
                if(dist[node.end] > dist[cur] + node.weight){
                    dist[node.end] = dist[cur] +node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}
