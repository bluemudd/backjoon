import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue_11866 {
    static Queue<Integer> q= new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sb = new StringTokenizer(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        int n = Integer.parseInt(sb.nextToken());
        int k = Integer.parseInt(sb.nextToken());
        int count = 1;
        for(int i =1; i<=n; i++){
            q.add(i);
        }

        while(q.size()>1){
            if (count%k==0){
                int r =q.poll();
                stringBuilder.append(r);
                stringBuilder.append(", ");
            }
            else{
                int s= q.poll();
                q.add(s);
            }
            count++;
        }
        stringBuilder.append(q.poll());
        stringBuilder.append(">");
        System.out.println(stringBuilder);

    }
}
