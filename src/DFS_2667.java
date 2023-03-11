import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DFS_2667 {
    private static int dX[] = {0,0,1,-1};
    private static int dY[] = {1,-1,0,0};
    private static int count =0;
    private static int numX, numY;
    private static int n;
    private static int Num = 0;
    private static int [][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j]=s.charAt(j)-'0';
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j] == false && map[i][j]==1){
                    count =0;
                    Num++;
                    DFS(i,j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(Num);
        for(int i =0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public static void DFS(int x, int y){
        visited[x][y]=true;
        map[x][y]= Num;
        count++;

        for(int i=0; i<4; i++){
            numX= x+dX[i];
            numY= y+dY[i];
            if(numX>=0 && numX<n && numY>=0 && numY<n && visited[numX][numY] == false && map[numX][numY] == 1){
                visited[numX][numY]= true;
                map[numX][numY]= Num;

                DFS(numX, numY);
            }
        }
    }
}
