import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tree_9934 {
    static int [] flow;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        k = Integer.parseInt(br.readLine());
        int size =(int)Math.pow(2, k)-1;
        flow = new int[size];
        st= new StringTokenizer(br.readLine());
        for(int j =0; j<flow.length; j++){
            flow[j] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<k; i++){
            list.add(new ArrayList<Integer>());
        }
        search(0, flow.length-1, 0);
        for(int i=0; i<k; i++){
            for(int j =0; j<list.get(i).size(); j++){
                sb.append(list.get(i).get(j)+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    public static void search(int start, int last, int depth){
        if(depth == k){
            return;
        }
        int mid = (start+last)/2;
        list.get(depth).add(flow[mid]);
        search(start, mid-1, depth+1);
        search(mid+1, last, depth+1);
    }
}
