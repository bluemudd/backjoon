import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Recursion_1780 {
    static int[][] map;
    static int one, minusone, zero =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println("");
//        }
        partition(0,0,N);
        System.out.println(minusone);
        System.out.println(zero);
        System.out.println(one);
    }
    public static void partition(int row, int col, int size){
        if(zeroCheck(row, col, size)){
            if(map[row][col]==0){
                zero++;
            }
            else if(map[row][col]==1){
                one++;
            }
            else{
                minusone++;
            }
            return;
        }
        size= size/3;
        partition(row, col, size);
        partition(row,col+size, size);
        partition(row, col+(size*2), size);
        partition(row+(size), col, size);
        partition(row+(size), col+(size), size);
        partition(row+(size), col+(size*2), size);
        partition(row+(size*2), col, size);
        partition(row+(size*2), col+(size), size);
        partition(row+(size*2), col+(size*2), size);
    }
    public static boolean zeroCheck(int row, int col, int size){
        int start = map[row][col];
            for(int i=row; i<row+size; i++){
                for(int j=col; j<col+size; j++){
                    if(start!=map[i][j]){
                        return false;
                    }
                }
            }
            return true;
    }
}
