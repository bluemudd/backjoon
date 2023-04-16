import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Recursion_6603 {
    public static int[] group;
    public static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if(k == 0){
                break;
            }
            group = new int[k];
            check = new boolean[k];
            int i = 0;
            while (st.hasMoreTokens()) {
                group[i] = Integer.parseInt(st.nextToken());
                i++;
            }
            Recursion(0, 0);
            System.out.println("");
        }
    }
    public static void Recursion(int start, int depth){
        if(depth == 6){
            for(int i=0; i<group.length; i++){
             if(check[i]){
                 System.out.print(group[i]+" ");
             }
            }
            System.out.println("");
        }
        for(int i = start; i<group.length; i++){
            check[i]=true;
            Recursion(i+1, depth+1);
            check[i]=false;
        }

    }
}
