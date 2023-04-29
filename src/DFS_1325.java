
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DFS_1325 {
    static int M ,N;
    static boolean [] hack;
    static int count =0;
    static int MAX=0;
    static ArrayList<Integer>[] belief;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        st= new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        belief = new ArrayList[N+1];

        for(int i =1; i<= N; i++ ){
            belief[i]= new ArrayList<>();
        }
        for(int i=1; i<=M; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
//            belief[a].add(b);
            belief[b].add(a);
        }
        for(int i=1; i<=N; i++){
            count=0;
            hack = new boolean[N+1];
            DFS(i);
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

    public static void DFS(int index){
        hack[index]=true;
        count++;
        for(int i = 0; i<belief[index].size(); i++){
            if (hack[belief[index].get(i)]){
                continue;
            }
            DFS(belief[index].get(i));
        }
    }
}
