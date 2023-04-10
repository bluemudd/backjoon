import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DFS_2664 {
    static int a, b;
    static int n, m;
    static ArrayList<List<Integer>> map;
    static int count=0;
    static int answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        visited = new boolean[n+1];
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        map = new ArrayList<List<Integer>>();
        for(int i=0; i<n+1; i++){
            map.add(new ArrayList<Integer>());
        }
        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int famA = Integer.parseInt(st.nextToken());
            int famB = Integer.parseInt(st.nextToken());
            map.get(famA).add(famB);
            map.get(famB).add(famA);
        }
//        for(int i=0; i<n; i++){
//            System.out.println(map.get(i));
//        }
        DFS(a);
        if(answer == 0){
            System.out.println(-1);
        }
        else {
            System.out.print(answer);
        }
    }
    static void DFS(int index){
        visited[index] = true;
        if(index == b){
            answer=count;
           return;
        }
//        System.out.print(index+"->");
        count++;
        for(int i=0; i<map.get(index).size(); i++){
            if(!visited[map.get(index).get(i)]) {
                DFS(map.get(index).get(i));
            }
        }
    }
}
