import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS_2468 {
    static int N;
    static int [] dx = {1, -1, 0 , 0};
    static int [] dy = {0, 0, -1, 1};
    static int [][] map;
    static boolean [][] visited;
    static int count;
    static int MAX_VALUE =0;
    static int [][] safetyZone;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
//        visited = new boolean[N][N];
//        safetyZone = new int[N][N];
        for(int i =0; i<N; i++){
            st= new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i =0; i<N+1; i++){
            count =0;
            safetyZone = new int[N][N];
            visited = new boolean[N][N];
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(map[j][k]<=i){
                        safetyZone[j][k]=1;
                    }
                    else{
                        safetyZone[j][k]=0;
                    }
                }
            }
            for(int a=0; a<N; a++){
                for(int b=0; b<N; b++){
                    if(safetyZone[a][b] == 0 && !visited[a][b]) {
                        search(a, b);
                        count++;
                    }
                }
            }
            MAX_VALUE = Math.max(MAX_VALUE, count);
        }
        System.out.println(MAX_VALUE);

    }
    public static void search(int row, int col){
        visited[row][col] = true;
        for(int i=0; i<dx.length; i++){
            int nx = row + dx[i];
            int ny = col + dy[i];
            if(nx>=0 && ny>=0 && nx<N && ny<N){
                if(!visited[nx][ny] && safetyZone[nx][ny] == 0){
                    search(nx, ny);
                }
            }
        }
    }
}
