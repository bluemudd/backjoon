import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PriorityQueue_15903 {
    static int m, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            Long a = Long.parseLong(st.nextToken());
            pq.add(a);
        }
        for(int i=0; i<n; i++){
            Long a = pq.poll();
            Long b = pq.poll();
//            System.out.println(a);
//            System.out.println(b);
            pq.add(a+b);
            pq.add(a+b);
        }
        long sum=0;
        while(!pq.isEmpty()){
            sum+=pq.poll();
        }
        System.out.println(sum);
    }
}
