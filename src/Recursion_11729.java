import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursion_11729 {
    public static StringBuilder sb = new StringBuilder();
    static int count =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((int) (Math.pow(2,N)-1)).append('\n');
        //Hanoi(n) = 2 X Hanoi(n-1)+1
        Hanoi(N,1,2,3);
        System.out.println(sb);

    }
    public static void Hanoi(int N, int start, int mid, int to){
        if(N == 1){
            count++;
            sb.append(start+" "+to+"\n");
            return;
        }
        Hanoi(N-1, start, to, mid);
        sb.append(start+" "+to+"\n");
        Hanoi(N-1, mid, start, to);
    }
}
