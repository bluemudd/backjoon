import java.io.*;
import java.util.Arrays;

class ex {

    // 아래 solution 메서드의 내용을 작성하여 프로그램을 완성해 주세요.
    public static void solution(int[][] bay) {
        for(int i =0; i<bay.length; i++){
            for(int m=0; m<bay.length; m++){
                System.out.print(bay[i][m]+" ");
            }
            System.out.println();
        }
    }

    static int[] dx = {1, 0, -1, 0}; //우, 하, 좌, 상
    static int[] dy = {0, 1, 0, -1};
    static int x = -1;
    static int y = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int j = 1;
        int turn = 0;
        int[][] bay = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        while (true) {
            y = y + dy[turn];
            x = x + dx[turn];
            if (y < 0) {
                y = y - dy[turn];
                turn = turn + 1;
                x = x + dx[turn];
                y = y + dy[turn];
            } else if (x < 0) {
                x = x - dx[turn];
                turn = turn + 1;
                x = x + dx[turn];
                y = y + dy[turn];
            }
            if (y == n) {
                y = y - dy[turn];
                turn = turn + 1;
                x = x + dx[turn];
                y = y + dy[turn];
            } else if (x == n) {
                x = x - dx[turn];
                turn = turn + 1;
                x = x + dx[turn];
                y = y + dy[turn];

            }
            if(visited[y][x]==true){
                x = x - dx[turn];
                y = y - dy[turn];
                if(turn == 3){
                    turn=0;
                }
                else {
                    turn++;
                }

                x = x + dx[turn];
                y = y + dy[turn];
                if(visited[y+dy[0]][x+dx[0]]==true&&visited[y+dy[1]][x+dx[1]]==true&&visited[y+dy[2]][x+dx[2]]==true&&visited[y+dy[3]][x+dx[3]]==true){
                    visited[y][x] = true;

                    bay[y][x] = j;
                    break;
                }

            }
            if (visited[y][x] == false) {
                visited[y][x] = true;

                bay[y][x] = j;
                j++;
            }

        }
        ex pg = new ex();
 		pg.solution(bay);

        // 배열의 크기 (입력 값)
// 		int size = 3;
// 		System.out.println("배열 크기 : " + size);

// 		Program pg = new Program();
// 		pg.solution(size);

    }
}
