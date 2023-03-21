import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS_11403 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // i에서 j까지 갈 수 있는가?
            // i에서 k로 가고, k에서 j로 갈 수 있는가?
            for (int k = 0; k < n; k++) { // 거쳐갈 노드
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        // 단순히 갈 수 있는 경로가 있는지만 체크
                        if (map[i][k] == 1 && map[k][j] == 1) {
                            System.out.print("("+(i+1)+","+(k+1)+")"+map[i][k]);
                            System.out.print("("+(k+1)+","+(j+1)+")"+map[k][j]);

                            System.out.print("다음");
                            map[i][j] = 1;
                        }
                    }
                    System.out.println("");
                }

            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);

        }
//    static ArrayList<ArrayList<Integer>> map;
//    static int [][] go;
//    static int N;
//    static int count;
//    static boolean [] visited;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        N = Integer.parseInt(br.readLine());
//        map = new ArrayList<>();
//        for(int a=0; a<N; a++){
//            map.add(new ArrayList<>());
//        }
//        go= new int[N][N];
//        for(int i=0; i<N; i++) {
//            String s = br.readLine().replaceAll(" ","");
//            for (int j = 0; j < N; j++) {
//                if(s.charAt(j)=='1'){
//                    map.get(i).add(j+1);
//                }
//            }
//        }
//
//        for(int i=0; i<N; i++){
//            visited = new boolean[N+1];
//            count=0;
//            dfs(i+1);
//            for(int j=0; j<N; j++){
//                if(visited[j+1]){
//                    go[i][j]=1;
//                }
//                else if (!visited[j+1]){
//                    go[i][j]=0;
//                }
//            }
//        }
//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                System.out.print(go[i][j]+" ");
//            }
//            System.out.println("");
//        }
//    }
//    static void dfs(int start){
//        if(count!=0){
//            visited[start]=true;
//        }
//        count++;
//        for(int i=0; i<map.get(start-1).size(); i++){
//            if(!visited[map.get(start-1).get(i)]){
//                dfs(map.get(start-1).get(i));
//            }
//        }
//
//    }
}
