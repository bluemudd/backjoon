import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_1697 {
    static int N ;//subin
    static int K ;// bro
    static int[] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[100001];
        visited = new boolean[100001];
        BFS(N);
        System.out.println(map[K]);
    }
    public static void BFS(int index){
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        while(!q.isEmpty()){
            int x = q.poll();
            int [] nextX = {x+1, x-1, 2*x};
            for(int i = 0; i<nextX.length; i++){
                if(nextX[i]<0 || nextX[i]>10001){
                    continue;
                }
                if(visited[nextX[i]]){
                    continue;
                }
                q.add(nextX[i]);
                visited[nextX[i]]=true;
                map[nextX[i]]=map[x]+1;
            }
        }
    }
//    public static void DFS(int index, int depth){
//        visited[index] = true;
//        int [] nextX = {index+1, index-1, 2*index};
//        for(int i=0; i <nextX.length; i++ ){
//            int x =nextX[i];
//            System.out.print(index+"->");
//            if(x<0 && x>K){
//                if(!visited[x]) {
//                    DFS(x, depth++);
//                    visited[x]= false;
//                }
//            }
//        }
//    }
}
