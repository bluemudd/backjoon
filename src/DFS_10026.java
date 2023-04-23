import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS_10026 {
    static String ch = "RGB";
    static String ch1 = "WB";
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int count =0;
    static int N;
    static char [][] pic;
    static char color ;
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        pic = new char[N][N];
        for (int i = 0; i < N; i++) {
            String picX = br.readLine();
            for (int j = 0; j < N; j++) {
                pic[i][j] = picX.charAt(j);
            }
        }
        for (int k = 0; k < ch.length(); k++) {
            color= ch.charAt(k);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]&& pic[i][j]==color) {
                        dfs(i,j);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        count=0;
        visited= new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(pic[i][j]=='R' || pic[i][j]=='G'){
                    pic[i][j]='W';
                }
            }
        }
        for (int k = 0; k < ch1.length(); k++) {
            color= ch1.charAt(k);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]&& pic[i][j]==color) {
                        dfs(i,j);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        count=0;
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0; i<dx.length; i++){
            int nx= x+dx[i];
            int ny= y+dy[i];
            if(ny>=0 && nx>=0 && nx<N && ny<N){
                if(!visited[nx][ny] && pic[nx][ny]==color){
                    dfs(nx,ny);
                }
            }
        }

    }
}
