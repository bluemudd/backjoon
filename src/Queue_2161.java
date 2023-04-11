import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queue_2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 1; i<=N; i++){
            q.add(i);
        }
        while(q.size() != 1) {
            int a = q.poll();
            q2.add(a);
            q.add(q.poll());
        }
        while(!q2.isEmpty()){
            System.out.print(q2.poll()+" ");
        }
        System.out.print(q.poll());

    }
}
