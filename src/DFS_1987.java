import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS_1987 {
    static int R, C;
    static int [] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean [][] visited;
    static char [][] map;
//    static int count = 0;
    static int max = 0;
    static ArrayList<Character> list = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i =0; i<R; i++){
            String s = br.readLine();
            for(int j = 0 ; j<C; j++){
                map[i][j]=s.charAt(j);
            }
        }
//        for(int i =0; i<R; i++){
//            for(int j =0; j<C; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println("");
//        }
        dfs(0,0,1);
        System.out.println(max);

    }
    public static void dfs(int row, int col, int depth){
        max = Math.max(max,depth);
        list.add(map[row][col]);
//        System.out.print(map[row][col]+" ");
        for(int i =0; i<dx.length; i++){
            int nextX = row+dx[i];
            int nextY = col+dy[i];
            if(nextX >=0 && nextY >=0 && nextX<R && nextY<C){
                if(!list.contains(map[nextX][nextY])){
//                    !visited[nextX][nextY] &&
                            dfs(nextX, nextY, depth+1);
                            list.remove(list.indexOf(map[nextX][nextY])); // 갔던길 탐색이 다 끝나면 히스토리 삭제. 다른 루트로 새로 히스토리가 남겨지기 때문.
                }
            }
        }
    }
}
