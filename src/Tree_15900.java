import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tree_15900 {
    static ArrayList<ArrayList<Integer>> tree;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree=new ArrayList<>();
        visited= new boolean[N+1];
        for(int i=0; i<=N; i++){
            tree.add(new ArrayList<>());
        }
        for(int i=0; i<N-1; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        dfs(1);
        System.out.println(count);
    }
    static void dfs(int start){
        visited[start] = true;
//        System.out.print(start+"->");
        count++;
        for(int i =0; i<tree.get(start).size(); i++){
//            System.out.print(tree.get(start).get(i)+","+visited[tree.get(start).get(i)]+" ");
            if(!visited[tree.get(start).get(i)]) {
                dfs(tree.get(start).get(i));
            }
            if (start != 1 && tree.get(start).size() == 1) {
                return;
            }

        }
//        if(start!=1&&tree.get(start).size()==1){
//            return;
//        }

    }
}
