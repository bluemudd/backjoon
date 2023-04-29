import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS_1707 {
    static int v,e;
    static ArrayList<Integer>[] map;
    static int[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb =new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for(int t =0; t<testCase; t++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            map = new ArrayList[v + 1];
            check = new int[v + 1];
            for (int i = 1; i <= v; i++) {
                map[i] = new ArrayList<>();
            }
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                map[v1].add(v2);
                map[v2].add(v1);
            }
            boolean isBinary=true;
            for(int i=1; i<=v; i++) {
                if(check[i] !=0) {continue;}
                isBinary=DFS(i, 1);
                if(!isBinary){
                    break;
                }
            }
            if(!isBinary) {
                sb.append("NO"+"\n");
            }
            else{
                sb.append("YES"+"\n");
            }
        }
        System.out.print(sb);




    }
    public static boolean DFS(int index, int color){
        check[index]=color;
        int nextColor=color*-1;
        boolean result=true;
        for(int i : map[index]){
            if(check[i]==0){
                result=DFS(i,nextColor);
            }
            else{
                if(check[i] == color){
                    return false;
                }
            }
            if(!result) return false;
        }
        return true;
    }

}
