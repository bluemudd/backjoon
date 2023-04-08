import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS_2667 {
    static int []dy={-1, 1, 0, 0};
    static int []dx={0, 0, -1, 1};
    static int N;
    static int [][] map;
    static int count;
    static boolean [][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        count=0;
        ArrayList<Integer> apartNum = new ArrayList<>();
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j]=s.charAt(j)-'0';
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]==1&& !visited[i][j]) {
                    BFS(i, j);
                    apartNum.add(count);
                    count = 0;
                }
            }
        }
        apartNum.sort(Comparator.naturalOrder());
        System.out.println(apartNum.size());
        for(int i=0; i<apartNum.size(); i++){
            System.out.println(apartNum.get(i));
        }


    }
    static void BFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        count++;
        visited[x][y]=true;
        while(!q.isEmpty()){
            int curX= q.peek()[0];
            int curY= q.peek()[1];
            q.poll();
            for(int i=0; i<dx.length; i++){
                int nx= curX+dx[i];
                int ny= curY+dy[i];
                if(nx >=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny] && map[nx][ny]==1){
                    q.add(new int[]{nx,ny});
                    visited[nx][ny]=true;
                    count++;
                }
            }

        }
    }
}
