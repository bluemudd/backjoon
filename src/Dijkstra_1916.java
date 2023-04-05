import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
        int end, weight;
        public Node(int end, int weight){
            this.end=end;
            this.weight=weight;
        }
        @Override
        public int compareTo(Node o){
            return weight - o.weight;
        }
}

public class Dijkstra_1916 {
    static List<Node>[] list;
    static int N, M;
//    private static final int INF = 100_000;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 정점
        M = Integer.parseInt(br.readLine()); // 간선
        list= new ArrayList[N+1];
        dist = new int[M+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=1; i<=N ; i++){
            list[i]= new ArrayList<>();
        }
        for(int i =0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
        }
        String answer[] = br.readLine().split(" ");
        int start = Integer.parseInt(answer[0]);
        int last = Integer.parseInt(answer[1]);
        Dijkstra(start);
        System.out.println(dist[last]);
    }
    public static void Dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean [] check = new boolean[N+1];
        dist[start] = 0;
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()){
//            for(int i=0; i<dist.length; i++){
//                System.out.print("["+dist[i]+"] ");
//            }
//            System.out.println("");
            Node curNode = queue.poll();
            int cur = curNode.end;
            if(check[cur]) continue;
            check[cur] = true;
            for(Node node : list[cur]){
                if(dist[node.end] > dist[cur]+node.weight){
                    dist[node.end]= dist[cur]+node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}
