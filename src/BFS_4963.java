import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_4963 {
    static int[][] map;
    static boolean[][] visited;
    static int w;
    static int h;
    static int count=0;
    static int[] mh = {-1, 1, 0, 0, 1, -1, 1, -1};//위 아래 오른쪽 왼쪽 오위 오밑 왼위 왼밑
    static int[] mw = {0, 0, 1, -1, 1, 1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb =new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0){
                break;
            }
            map = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                String s = br.readLine().replaceAll(" ", "");
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }
            for (int a = 0; a < h; a++) {
                for (int b = 0; b < w; b++) {
                    if (!visited[a][b] && map[a][b] == 1) {
                        bfs(b, a);
                        count++;
                    }
                }
            }
            sb.append(count+"\n");
            count=0;
        }
        System.out.print(sb);
    }
    static void bfs(int w1, int h1){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {w1, h1});
        visited[h1][w1]=true;
        while(!q.isEmpty()){
            int NowW = q.peek()[0];
            int NowH = q.peek()[1];
            int [] a=q.poll();
//            System.out.print(a[0]+","+a[1]+"->");
            for(int i=0; i<mh.length; i++){
                int NextW = NowW+mw[i];
                int NextH = NowH+mh[i];
                if(NextW>=0 && NextH>=0 && NextH<h && NextW<w && !visited[NextH][NextW] && map[NextH][NextW]==1){
                    q.add(new int[] {NextW, NextH});
                    visited[NextH][NextW]=true;
                }
            }
        }

    }
}
