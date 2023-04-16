import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st= new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long [] line = new long[K];
        long high =0;
        long low = 0;
        for(int i =0; i<K; i++){
            line[i]=Long.parseLong(br.readLine());
            if(line[i]>high) {
                high = line[i];
            }
        }
        long answer=0;
        while(low<high){
            long mid = (low+high)/2;
            long count = 0;
//            System.out.println("mid는 "+mid+"/ high는 "+high+"/ low는 "+low);
            for(int i=0; i<K; i++){
                count+=line[i]/mid;
//                System.out.println(line[i]+"은 "+count);
            }

            if(N > count){
                high=mid-1;

            }
            else if (N <= count){
                low=mid+1;
                if(N==count){
                    answer=mid;
                }
            }
//            System.out.println(count);
        }
        System.out.println(answer);

    }
}
