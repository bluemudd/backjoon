import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra_1753_2 {
    static int v,e,k;
    static int [] dist;
    static List<Node>[] list;
    static int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        list = new ArrayList[v+1];
        dist = new int[v+1];
        Arrays.fill(dist,INF);
        for(int i= 1 ; i<=v; i++){
            list[i]= new ArrayList<>();
        }
        for(int i =0; i<e; i++){
            st= new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v,w));
        }
        dijkstra(k);
        StringBuilder sb = new StringBuilder();
        for(int i =1; i<=v; i++) {
            if(dist[i]==INF) {
                sb.append("INF"+"\n");
            }
            else{
                sb.append(dist[i]+"\n");
        }
        }
        System.out.println(sb);


    }
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean [] check = new boolean[v+1];
        pq.add(new Node(start,0));
        dist[start]=0;
        while(!pq.isEmpty()){
            Node nowNode = pq.poll();
            int nowEnd = nowNode.end;
            if(check[nowEnd] == true) continue;
            check[nowEnd]=true;

            for(Node node : list[nowEnd]){
                if(dist[node.end] > dist[nowEnd]+node.weight){
                    dist[node.end] = dist[nowEnd]+ node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }

}

//class Node_17532 implements Comparable<Node_17532>{
//    int end, weight;
//    public Node_17532(int end, int weight){
//        this.end=end;
//        this.weight=weight;
//    }
//    @Override
//    public int compareTo(Node o){
//        return weight - o.weight;
//    }
//}
