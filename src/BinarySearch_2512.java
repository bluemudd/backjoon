import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch_2512 {
    static int [] map;
    static int N;
    static long wages;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            map[i] =Integer.parseInt(st.nextToken());
        }
        wages = Long.parseLong(br.readLine());
        Arrays.sort(map);
        int min = 0;
        int max = map[N-1];
//        System.out.println(min);
//        System.out.println(max);
        while(min <= max){
            int mid = (min+max)/2;
            long budget=check(mid);
            if(budget<=wages){
                min = mid+1;
            }
            else {
                max=mid-1;
            }

        }
        System.out.println(max);
    }
    public static long check(int mid){
        long sum = 0;
        for(int i=0; i<N; i++){
            if(map[i]<=mid){
                sum+=map[i];
            }
            else {
                sum+=mid;
            }
        }
        return sum;
    }
}
