import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Greedy_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum=0;
        int [] P = new int[N];
        int i=0;
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            P[i]=Integer.parseInt(st.nextToken());
            i++;
        }
        Arrays.sort(P);
        for(int j=1; j<=P.length; j++){
            for(int t=0; t<j; t++){
                sum+=P[t];
            }
        }
        System.out.println(sum);


    }
}
