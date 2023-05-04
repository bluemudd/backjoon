import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_1325 {
    static int N,M;
    static boolean[] hack;
    static int count = 0;
    static int MAX;
    static ArrayList<Integer> [] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        st= new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        map = new ArrayList[N+1];
        hack = new boolean[N+1];
        for(int i =1; i<=N; i++){
            map[i]= new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st= new StringTokenizer(br.readLine());
            int N1 = Integer.parseInt(st.nextToken());
            int N2 = Integer.parseInt(st.nextToken());
            map[N2].add(N1);
        }
        for(int i=1; i<=N; i++){
            count=0;
            hack = new boolean[N+1];
            BFS(i);
            if(MAX<count){
                sb= new StringBuilder();
                MAX=count;
                sb.append(i+" ");
            }
            else if(MAX==count){
                sb.append(i+" ");
            }
        }

        System.out.println(sb);
    }
    public static void BFS(int index){
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        hack[index]=true;
        count++;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i =0; i<map[now].size(); i++){
                if(hack[map[now].get(i)]){
                    continue;
                }
                q.add(map[now].get(i));
                hack[map[now].get(i)]=true;
                count++;
            }
        }
    }
}
