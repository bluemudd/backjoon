import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PriorityQueue_19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        PriorityQueue<time> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new time(a, true));
            pq.add(new time(b, false));
        }
        int MAX=0;
        int Class=0;
        while(!pq.isEmpty()){
            time t = pq.poll();
            if(t.executing){
                Class++;
                MAX=Math.max(Class,MAX);
            }
            else{
                Class--;
            }
        }
        System.out.println(MAX);
    }
}
class time implements Comparable<time>{
    int now;
    boolean executing;
    public time(int now, boolean executing){
        this.now=now;
        this.executing=executing;
    }

    @Override
    public int compareTo(time o) {
        return this.now-o.now;
    }
}
