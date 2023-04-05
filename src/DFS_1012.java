import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS_1012 {
    static int M, N, K;
    static int [] dx = {0, 0, -1, 1}; //상하좌우
    static int [] dy = {1, -1, 0, 0 };
    static int count;
    static boolean [][] visited;
    static int [][] cabbage;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb= new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cabbage = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                cabbage[a][b] = 1;
            }
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && cabbage[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count+"\n");
            count = 0;
        }
        System.out.print(sb);
    }
    public static void dfs(int x, int y){
        visited[x][y]=true;

        for(int i=0; i<dx.length; i++){
            int nextX=x+dx[i];
            int nextY=y+dy[i];
//            System.out.println(x+","+y+" "+visited[x][y]+", "+cabbage[x][y]);
            if(nextX>=0 && nextX<M && nextY>=0 && nextY<N && !visited[nextX][nextY] && cabbage[nextX][nextY] == 1){
                dfs(nextX,nextY);
            }
        }
    }
}
