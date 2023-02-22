import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Divide_1992 {
    public static int [][] img;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int b = Integer.parseInt(br.readLine());
        img = new int[b][b];
        for(int i =0; i<b; i++){
            String m = br.readLine();
            for(int j=0; j<b; j++){
                img[i][j]=m.charAt(j);
            }
        }
    }
}
