import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PriorityQueue_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int turn = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Collections.reverseOrder());
        for(int i = 0; i<turn; i++){
            st= new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=0; i<turn-1; i++){
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}
