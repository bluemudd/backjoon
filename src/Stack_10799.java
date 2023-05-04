import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_10799 {
    static int count;
    static int sum;
    static char priorA ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>();
        sum=0;
        count=0;

        String st= br.readLine();
        for(int i=0; i<st.length(); i++){
            char a = st.charAt(i);
            if(a == '('){
                s.add(count);
                count++;
            }
            else if (a == ')' && priorA=='('){
                count--;

                if(!s.isEmpty()) {
                    sum += s.peek();
                }
                s.pop();
            }
            else {
                sum++;
                count--;
            }
            priorA=a;

//            System.out.println(count+" "+sum);
        }
        System.out.println(sum);

    }
}
