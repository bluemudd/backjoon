import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Recursion_2630 {
    static int N;
    static int blue = 0;
    static int white= 0;
    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0,0,N);
        System.out.println(blue);
        System.out.println(white);

    }
    public static void partition(int row, int col, int size){
        if(blueCheck(row,col,size)){
            if(map[row][col]==1){
                white++;
            }
            else{
                blue++;
            }
            return;
        }
        int newSize = size/2;
        partition(row,col,newSize);
        partition(row,col+newSize,newSize);
        partition(row+newSize, col, newSize);
        partition(row+newSize, col+newSize, newSize);

    }
    public static boolean blueCheck(int row, int col, int size){
        int color = map[row][col];
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(map[i][j]!=color){
                    return false;
                }
            }
        }
        return true;
    }
}
