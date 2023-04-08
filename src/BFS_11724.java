import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS_11724 {
    static int M,N; //M - 간선의 개수, N - 정점의 개수
    static boolean [] visited;
    static ArrayList<List<Integer>> al;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점
        M = Integer.parseInt(st.nextToken()); // 간선
        visited = new boolean[N+1];
        al = new ArrayList<>();
        for(int i=0; i<=N; i++){
            al.add(new ArrayList<>());
        }
        for(int j=0; j<M; j++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            al.get(a).add(b);
            al.get(b).add(a);

        }
        for(int l=1; l<=N; l++){
            if(!visited[l]) {
                bfs(l);
                count++;
            }

        }
        System.out.print(count);

    }

    static void bfs(int index){
        Queue<Integer> q = new LinkedList<>();
        visited[index] = true;
        q.add(index);
        while(!q.isEmpty()){
            index = q.poll();
//            System.out.print(index+" ");
            for(int i=0; i<al.get(index).size(); i++){
                if(!visited[al.get(index).get(i)]) {
                    q.add(al.get(index).get(i));
                    visited[al.get(index).get(i)]=true;
                }
            }
        }
    }
}
