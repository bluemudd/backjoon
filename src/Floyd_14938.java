import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Floyd_14938 {
    static int n, m, r;
    static int [][] map;
    static int [] item;
    static int INF = 16;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        item= new int[n+1];
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            item[i+1] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                map[i][j]=INF;
            }
        }
        for(int i=0; i<r; i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b]=c;
            map[b][a]=c;
        }

        for(int i=1; i<=n;i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(i==j || j==k || i==k){
                        continue;
                    }
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }
//        for(int i=1; i<=n; i++){
//            for(int j=1; j<=n; j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println("");
//        }
        int max=0;
        for(int i=1; i<=n; i++){
            int sum=item[i];
            for(int j=1; j<=n; j++){
                if (map[i][j]<=m){
                    sum+= item[j];
                }
            }
//            System.out.println(sum);
            max=Math.max(max,sum);

        }
        System.out.println(max);
    }
}
