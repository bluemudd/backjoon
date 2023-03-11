import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Tree_9372 {
    public static int[][] map;
    public static boolean[] visited;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int nation;
        int flight;
        int turn = 0;
        while (turn < t) {
            st = new StringTokenizer(br.readLine());
            nation = Integer.parseInt(st.nextToken());
            flight = Integer.parseInt(st.nextToken());
            count=-1;
            visited = new boolean[nation];
            map = new int[nation][nation];
            for (int i = 0; i < flight; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a - 1][b - 1] = 1;
                map[b - 1][a - 1] = 1;
            }
            dfs(1);
            sb.append(count).append("\n");
            turn++;
        }
        System.out.println(sb);
    }

    static void dfs(int start){
        visited[start-1]=true;
        count++;
//        System.out.print(start + "->");
        for(int j =1; j<=map[start-1].length; j++){
            if(map[start-1][j-1] != 0 && visited[j-1] == false) {
                dfs(j);
            }
        }
    }
}
