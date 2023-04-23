import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch_10816 {
    static double [] cards;
    static double [] myCards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        cards = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = 0;
        int t =0;
        while(st.hasMoreTokens()){
            cards[k]=Integer.parseInt(st.nextToken());
            k++;
        }
        Arrays.sort(cards);
        int M = Integer.parseInt(br.readLine());
        myCards = new double[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        while(st2.hasMoreTokens()){
            myCards[t]=Integer.parseInt(st2.nextToken());
            t++;
        }
        for(int i=0; i<M; i++){
            sb.append(upperBound(0,N, (int)myCards[i])-lowerBound(0,N,(int)myCards[i])+" ");
        }

        System.out.println(sb);
//        System.out.println(sb);

    }
    public static int lowerBound(int start, int end, int x) {
        while(start < end){
            int mid = start+(end-start)/2;
            if(x<= cards[mid]){
                end = mid;
            }
            else{
                start = mid +1;
            }
        }
//        int i = start;
//        int count = 0;
//        while(cards[i] == x){
//            count++;
//            i++;
//            if(i==cards.length){
//                break;
//            }
//
//        }
        return start;
    }
    public static int upperBound(int start, int end, int x){
        while(start < end){
            int mid = start+(end-start)/2;

            if(x< cards[mid]){
                end=mid;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }

}
