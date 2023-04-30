import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Floyd_1956 {
    static int v, e, k;
    static int [][] map;
    static int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st= new StringTokenizer(br.readLine());
        v= Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        map = new int[v+1][v+1];
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            map[v1][v2]=Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<v+1; i++) {
            for (int j = 1; j < v + 1; j++) {
                if(i == j){map[i][j]=0;}
                else if (map[i][j] == 0) {
                    map[i][j] = INF;
                }
            }
        }
        for(int i=1; i<v+1; i++){
            for(int j=1; j<v+1; j++){
                for(int k=1; k<v+1; k++){
                    if(i==j){
                        continue;
                    }
                    map[i][k]=Math.min(map[i][k],map[i][j]+map[j][k]);
                }
            }
        }
        int go = INF;
        for(int i=1; i<=v; i++){
            for(int j=1; j<=v; j++){
                if(i==j){
                    continue;
                }
                if(map[i][j] != INF && map[j][i] !=INF){
                    go= Math.min(go, map[i][j] + map[j][i]);
                }
            }
        }
        if(go == INF){
            go=-1;
        }
        System.out.println(go);
    }
}
