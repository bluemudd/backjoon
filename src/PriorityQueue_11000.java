import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PriorityQueue_11000 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<jongTime> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new jongTime(a, true));
            pq.add(new jongTime(b, false));
        }
        int count =0;
        int result=0;
        jongTime priorJt = new jongTime(0,true);
        while(!pq.isEmpty()){
            jongTime jt = pq.poll();
            System.out.println(jt.time+" "+jt.executing);

            if(priorJt.time == jt.time && priorJt.executing != jt.executing){
                count--;
                result--;
            }
            else if(jt.executing){
                count++;
                result=Math.max(result, count);
            }
            else if(!jt.executing){
                count--;
            }
            System.out.println(count+" "+result);
            priorJt=jt;
        }

        System.out.println(result);

    }
}
class jongTime implements Comparable<jongTime>{
    int time;
    boolean executing;
    public jongTime(int time, boolean executing){
        this.time=time;
        this.executing=executing;
    }

    @Override
    public int compareTo(jongTime o) {
        return this.time-o.time;
    }
}
