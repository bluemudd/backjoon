import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Floyd_2458 {
    static int count =0;
    static int content=0;
    static int [][]map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        int N =Integer.parseInt(st.nextToken());
        int M =Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            map[a][b]=1;
            map[b][a]=2;
        }
//        for(int i=1; i<N+1; i++){
//            for(int j=1; j<N+1; j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println("");
//        }
//        System.out.println("---------------------------------");
        for(int k=1; k<N+1; k++){
            for(int i=1; i<N+1; i++){
                for(int j=1; j<N+1; j++){
                    if(map[i][k] == 1 && map[k][j]==1){map[i][j] =1; map[j][i]=2;}
                }
            }
        }
//        for(int i=1; i<N+1; i++){
//            for(int j=1; j<N+1; j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println("");
//        }

        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
               if(map[i][j]==0){count++;}
            }
            if(count==1){
                content++;
            }
            count=0;
        }
        System.out.println(content);

    }
}
