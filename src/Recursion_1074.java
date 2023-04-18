import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Recursion_1074 {
    static int count=-1;
    static int r, c;
    static int [] dx = {0,0,1,1};
    static int answer = 0;
    static int [] dy = {0,1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N2 = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int N=1;
        while(N2>0){
            N*=2;
            N2--;
        }
//        map = new double[N][N];
        partitionZ(0,0,N);
        System.out.println(answer);
    }
    public static void partitionZ(int row, int col, int size){
        if(size == 2) {
            if (row <= r && r <= row + size && col <= c && c <= col + size) {
                for (int i = 0; i < 4; i++) {
                    int x = row + dx[i];
                    int y = col + dy[i];
                    count++;
                    if ((x == r) && (y == c)) {
                        answer = count;
                        return;
                    }
//                System.out.print(x);
//                System.out.print(","+y);
//                System.out.println(": "+count);
                }
                return;
//            map[row][col]=count++;
//            map[row][col+1]=count++;
//            map[row+1][col]=count++;
//            map[row+1][col+1]=count++;
//            return;
            }
            else {
                count += 4;
                return;
            }
        }
        size = size/2;
        partitionZ(row,col, size);
        partitionZ(row,col+size,size);
        partitionZ(row+size,col,size);
        partitionZ(row+size,col+size,size);
    }
}
