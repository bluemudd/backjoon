import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> t = new Stack<>();
//        Stack<Integer> result = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n =Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j =0;
        for(int i =1; i<=n; i++){
            t.add(i);
        }
        sb.append("<");
        while(t.size()>0){
            j=j+m-1;
            if(j>=t.size()){
                j=j%t.size();
            }
            if(t.size()==1){
                int r =t.remove(j);
                sb.append(r);
            }
            else{
                int r =t.remove(j);
                sb.append(r+", ");
            }


        }
        sb.append(">");
        System.out.print(sb);
    }
}
