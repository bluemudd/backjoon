import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_7576 {
    static int[][] map;
    static int x1;
    static int y1;
    static int [] mx = {-1, 1, 0 ,0};
    static int [] my = {0,0,-1,1};
    static int max = 0;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x1= Integer.parseInt(st.nextToken());
        y1= Integer.parseInt(st.nextToken());
        map = new int[y1][x1];
        for(int i = 0; i< y1; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<x1; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    q.add(new int[]{i, j});
                }
            }
        }
        bfs();
        loop:
        for(int j=0; j<y1; j++){
            for(int i=0; i<x1; i++){
                if(map[j][i] > max){
                    max=map[j][i];
                }
                else if (map[j][i] == 0){
                    max = 0;
                    break loop;
                }
//                System.out.print(map[j][i]+" ");
            }
//            System.out.println("");
        }
        System.out.println(max-1);
    }
    private static void bfs(){
        while(!q.isEmpty()){
            int [] a = q.poll();
            int m = a[0]; // y
            int n = a[1]; // x
            for(int i = 0; i< 4; i++){
                int nextY = m+my[i];
                int nextX = n+mx[i];
                if(nextX < 0 || nextY <0 || nextX>=x1 || nextY>=y1){
                    continue;
                }
                if(map[nextY][nextX]==0) {
                    q.add(new int[]{nextY, nextX});
                    map[nextY][nextX] = map[m][n] + 1;
                }
            }
        }
    }
}
