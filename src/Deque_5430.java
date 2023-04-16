import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Deque_5430 {
    static int[] flow;
    static Deque<Integer> dq = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc =Integer.parseInt(br.readLine());
//        int p = Integer.parseInt(br.readLine());
        for(int j =0; j<tc; j++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            flow = new int[n];
            st = new StringTokenizer(br.readLine().replaceAll("\\[", "").replaceAll("\\]", ""), ",");
            for (int i = 0; i < n; i++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }
            playDeque(p);
            System.out.println(sb);
            dq= new LinkedList<>();
            sb = new StringBuilder();

        }
    }
    static void playDeque(String play){
        sb.append("[");
        int rules = 1;
        for(int i =0; i<play.length(); i++){
            char c = play.charAt(i);
            if(c =='R'){
                rules *= -1;
            }
            else if(c == 'D'){
                if(rules == -1 && !dq.isEmpty()){
                    dq.pollLast();
                }
                else if(rules == 1 && !dq.isEmpty()){
                    dq.pollFirst();
                }
                else if(dq.isEmpty()){
                    sb.setLength(0);
                    sb.append("error");
                    return;
                }
            }
        }
        while(!dq.isEmpty()) {
            if (rules == 1) {
                int a = dq.pollFirst();
                sb.append(a).append(",");
            }
            else {
                int a = dq.pollLast();
                sb.append(a).append(",");
            }
        }
        sb.deleteCharAt(sb.length() -1).append("]");
    }
}
