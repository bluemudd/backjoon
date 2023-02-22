import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue_18258 {
    public static void main(String[] args) throws IOException {
        Queue<Integer> q = new LinkedList<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int first = 0;
        for (int i = 0; i < t; i++) {
            String f = br.readLine();
            StringTokenizer st = new StringTokenizer(f);
            String order = st.nextToken();
            if (order.equals("push")) {
                int X = Integer.parseInt(st.nextToken());
                first = X;
                q.add(X);
            } else if (order.equals("empty")) {
                if (q.isEmpty()){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            } else if (order.equals("pop")) {
                if(q.isEmpty()){
                    System.out.println(-1);
                }
                else if(!q.isEmpty()) {
                    System.out.println(q.poll());
                }
            } else if (order.equals("size")) {
                System.out.println(q.size());
            } else if (order.equals("front")) {
                if(!q.isEmpty()) {
                    System.out.println(q.peek());
                }
                else{
                    System.out.println(-1);
                }
            } else if (order.equals("back")) {
                if(!q.isEmpty()) {
                    System.out.println(first);
                }
                else{
                    System.out.println(-1);
                }
            }
        }
    }

}
