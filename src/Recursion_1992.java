import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Recursion_1992 {
    static int  [][] map;
    static int N;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            String b = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j]=b.charAt(j)-'0';
            }
        }
//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println("");
//        }
        partition(0,0,N);
        System.out.println(sb);
    }
    public static void partition(int row, int col, int size){
        if(blueCheck(row, col, size)){
            if(map[row][col]==1){
                sb.append("1");
            }
            else{
                sb.append("0");
            }
            return;
        }
        sb.append("(");
        int newSize= size/2;
        partition(row, col, newSize);
        partition(row, col+newSize, newSize);
        partition(row+newSize, col, newSize);
        partition(row+newSize, col+newSize, newSize);
        sb.append(")");

    }
    public static boolean blueCheck(int row, int col, int size){
        int cash = map[row][col];
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(map[i][j] != cash){
                    return false;
                }
            }
        }
        return true;
    }
}
