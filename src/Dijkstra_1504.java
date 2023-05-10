import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Dijkstra_1504 {
    static ArrayList<Node>[] graph;
    static int N, E;
    static int [] dist;
    static int INF = 200000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph= new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        st=new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int min =0;
        int go1= Dijkstra(N,1,a)+Dijkstra(N,a,b)+Dijkstra(N,b,N);
        int go2= Dijkstra(N,1,b)+Dijkstra(N,b,a)+Dijkstra(N,a,N);
        min=(go1 >= INF && go2 >= INF) ? -1 : Math.min(go1, go2);
        System.out.println(min);

    }
    public static int Dijkstra(int n, int start, int last){
        boolean[] check = new boolean[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            int nowvertex = pq.poll().end;
            if(check[nowvertex]){continue;}
            check[nowvertex]=true;

            for(Node next : graph[nowvertex]){
                if(dist[next.end] > dist[nowvertex]+next.weight){
                    dist[next.end] = dist[nowvertex]+next.weight;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }
        return dist[last];
    }
}
