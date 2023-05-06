import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack_17413 {
    static boolean cur = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr = br.readLine();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<arr.length(); i++){
            char s = arr.charAt(i);
            if(s == '<'){
                while(!st.isEmpty()){
                    System.out.print(st.pop());
                }
                cur = true;
                System.out.print(s);
            }
            else if(s == '>'){
                cur = false;
                System.out.print(s);
            }
            else if(cur) {
                System.out.print(s);
            }
            else if(s == ' ' && !cur){
                while(!st.isEmpty()){
                    System.out.print(st.pop());
                }
                System.out.print(s);
            }
            else{
                st.push(s);
            }
        }
        while(!st.isEmpty()){
            System.out.print(st.pop());
        }



    }
}
