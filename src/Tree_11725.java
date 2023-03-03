import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tree_11725 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int n = Integer.parseInt(br.readLine());
        int [][] tree = new int[n][n];
        int [] tree2 = new int[n];
        for(int i =1; i<n; i++){
            st= new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            tree[a-1][b-1] = 1;
            tree[b-1][a-1] = 1;
        }
        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++) {
                if(tree[i][j] == 1){
                    if(tree2[j] == 0 && tree2[i] != j+1) {
                        tree2[j] = i + 1;
                    }
                }
            }
        }
        for(int i=1; i<n; i++){
            System.out.println(tree2[i]);
        }
        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.print(usedMemory + " bytes");

    }
}
