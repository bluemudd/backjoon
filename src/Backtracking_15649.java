import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_15649 {
    static int N,M;
    static boolean check [];
    static int a [];
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N+1];
        a = new int[N+1];

        go(0);

        System.out.println(sb);
    }
    public static void go(int index){
        if(index == M){
            for(int i=0; i<M; i++){
                sb.append(a[i]+" ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 1; i<=N; i++){
            System.out.println(index);
            if (check[i]) continue;
            check[i] = true;
            a[index]=i;
            go(index+1);
            check[i] = false;
        }
    }

}
