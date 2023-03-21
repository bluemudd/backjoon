import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Floyd_11404 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (map[x][y] == 0) {
                map[x][y] = cost;
            } else {
                map[x][y] = Math.min(map[x][y], cost);
            }
        }
        for (int j = 1; j < n + 1; j++) {
            for (int k = 1; k < n + 1; k++) {
                for (int t = 1; t < n + 1; t++) {
                    if (map[k][t]==0 && map[k][j] != 0 && map[j][t] != 0 && k!=t && k!=j && j !=t) {
                        map[k][t] = map[k][j] + map[j][t];
                    }
                    else if (map[k][t]!=0 && map[k][j] != 0 && map[j][t] != 0 && k!=j && j !=t && k != t) {
                        map[k][t] = Math.min(map[k][t], map[k][j] + map[j][t]);
                    }

                }
            }
        }
            for (int b = 1; b < n + 1; b++) {
                for (int k = 1; k < n + 1; k++) {
                    System.out.print(map[b][k] + " ");
                }
                System.out.println("");
            }
        }
}
