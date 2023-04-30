import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS_1926 {
    static int row, col, count, many, max;
    static int [][] pic;
    static boolean[][] check;
    static int [] my = {1, -1, 0, 0};
    static int [] mx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        pic = new int[col][row];
        check = new boolean[col][row];
        for(int i =0; i<col; i++){
            st= new StringTokenizer(br.readLine());
            for(int j =0; j<row; j++){
                pic[i][j]=Integer.parseInt(st.nextToken());
            }
        }

//        for(int i=0; i<col; i++){
//            for(int j=0; j<row; j++){
//                System.out.print(pic[i][j]+" ");
//            }
//            System.out.println("");
//        }

        for(int i=0; i<col; i++){
            for(int j=0; j<row; j++){
                if(pic[i][j] == 1 && !check[i][j]){
                    count=0;
//                    System.out.println(i+","+j);
                    dfs(i, j);
                    max=Math.max(max, count);
                    many++;
                }
            }
        }
        System.out.println(many);
        System.out.println(max);
    }
    public static void dfs(int y, int x){
        check[y][x]=true;
        count ++;

        for(int i=0; i<4; i++){
            int nextX= x+mx[i];
            int nextY= y+my[i];

            if(nextX>=row || nextY>=col || nextX<0 || nextY<0){
               continue;
            }
            if(check[nextY][nextX] || pic[nextY][nextX]==0){
                continue;
            }
            dfs(nextY, nextX);
        }
    }
}
