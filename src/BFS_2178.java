import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_2178 {
    static int[][] map;
    static int n;
    static int m;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0,0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i =0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = s.charAt(j) - '0';
//                System.out.print(map[i][j]);
            }
//            System.out.println("");
        }
        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs(0,0);
        System.out.println(map[n-1][m-1]);
//        for(int i =0; i<n; i++){
//            for(int j=0; j<m; j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println("");
//        }
    }
    public static void bfs(int x, int y){
         Queue<int []> q = new LinkedList<>();
         q.add(new int [] {x, y});

         while(!q.isEmpty()){
             int [] a = q.poll();
             int nowX = a[0];
             int nowY = a[1];

             for(int i=0; i<4; i++){
                 int nextX = nowX+dx[i];
                 int nextY = nowY+dy[i];

                 if (nextX <0 || nextY <0 || nextX >=n || nextY >=m){
                     continue;
                 }
                 if (visited[nextX][nextY]|| map[nextX][nextY]==0){
                     continue;
                 }
                 q.add(new int[] {nextX, nextY});
                 visited[nextX][nextY] = true;
                 map[nextX][nextY]=map[nowX][nowY]+1;

             }

         }
    }
}
