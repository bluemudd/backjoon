import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_7562 {
    static int p;
    static int[][] map;
    static boolean[][] visited;
    static int x, y;
    static int px,py;
    static int [] mx = {-1,-2,-2,-1,1,2,2,1};
    static int [] my = {-2,-1,1,2,2,1,-1,-2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;
        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++) {
            p = Integer.parseInt(br.readLine());
            map = new int[p][p];
            visited = new boolean[p][p];
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            px = Integer.parseInt(st.nextToken());
            py = Integer.parseInt(st.nextToken());
            bfs(x, y);
//            for(int c=0; c<p; c++) {
//                for(int b=0; b<p; b++) {
//                    System.out.print(map[b][c]);
//                }
//                System.out.println("");
//            }
            sb.append(map[py][px]+"\n");
        }
        System.out.println(sb);
    }
    private static void  bfs (int a, int b){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int [] {b, a});
        visited[b][a]=true;
        while(!q.isEmpty()){
            int [] now = q.poll();
            int nowY = now[0];
            int nowX = now[1];
            for(int i =0; i<8; i++){
                int nextY = nowY+my[i];
                int nextX = nowX+mx[i];
                if(nextY<0 || nextX<0 || nextX>=p || nextY>=p){
                    continue;
                }
                if(visited[nextY][nextX]){
                    continue;
                }
                q.add(new int []{nextY,nextX});
                visited[nextY][nextX]=true;
                map[nextY][nextX]=map[nowY][nowX]+1;
            }
        }

    }
}
