import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch_2805 {
    static int [] woods;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        woods = new int[N];
        st=new StringTokenizer(br.readLine());
        int MAX=0;
        for(int i=0; i<N; i++){
            woods[i]=Integer.parseInt(st.nextToken());
            if(woods[i]>MAX){
                MAX=woods[i];
            }
        }
        int low =0;
        int high = MAX;
        long H =0;
        while(low<=high){
            int mid = (low+high)/2;
            long count=0;
            System.out.print("mid: "+mid);
            System.out.print(" low: "+low);
            System.out.println(" high: "+high);
            for(int wood : woods){
                if(wood>mid){
                    count+=(wood -mid);
                }
            }
            System.out.println("M: "+M+", count: "+count);
            if(M <= count){
                low = mid +1;
                System.out.println("lowChange: "+low);
            }
            else {// m >count
                high = mid -1;
                System.out.println("highChange: "+high);
            }
        }
        System.out.println(high);

    }
}
