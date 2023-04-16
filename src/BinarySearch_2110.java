import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch_2110 {
    static int N, C;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//집 개수
        C = Integer.parseInt(st.nextToken());//공유기
        map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(map);
        int lo = 1;
        int hi = map[N-1]-map[0]+1;
        while(lo <hi){
            int mid = (lo+hi)/2;
            if(canInstall(mid)<C){
                hi=mid;
            }
            else{
                lo=mid+1;
            }
        }
        System.out.println(lo-1);
    }
    public static int canInstall(int distance){
        int count=1;
        int lastDistance =map[0];
        for(int i =0; i<map.length; i++){
            int displus = map[i];
            if(displus-lastDistance >= distance){
                count++;
                lastDistance=displus;
            }
        }
        return count;
    }
}
