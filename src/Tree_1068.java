import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tree_1068 {
    static int count=0;
    static class Node {
        int num;
        Node left;
        Node right;
        Node(int num) {
            this.num = num;
        }
        Node(int num, Node left, Node right) {
            this.left = left;
            this.num = num;
            this.right = right;
        }


        void Search(int father, int m, Node o){
            if(o == null){
                return;
            }
            if(o.num == father){
                if(o.left == null){
                    o.left = new Node(m);
                }
                else if(o.right == null){
                    o.right = new Node(m);
                }
            }
            else {
                Search(father, m, o.right);
                Search(father, m, o.left);

            }
        }
        void rid(Node no, int n){
            if(no == null){
                return;
            }
            else if (no.left == null){
                return;
            }
            else if(no.right == null){
                return;
            }
            if(no.num == n){
                no = null;
            }
            else if (no.left.num == n) {
                no.left = null;
            }
            else if (no.right.num == n) {
                no.right = null;
            }
            else {
                rid(no.left, n);
                rid(no.right, n);
            }

        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node root = null;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i=0;
        while(st.hasMoreTokens()){
            int a = Integer.parseInt(st.nextToken());
            if(a == -1){
                root=new Node(i);
            }
            else {
                root.Search(a, i, root);
            }
            if(i>=N){
                break;
            }
            i++;
        }

        int r = Integer.parseInt(br.readLine());
        root.rid(root, r);
        postOrder(root);
        count(root);
        System.out.println();
        System.out.println(count);

    }
    static void count(Node no){
        if(no==null){
            return;
        }
        if(no.left==null && no.right==null){
            count++;
        }
        count(no.left);
        count(no.right);
    }
    static void postOrder(Node no){
        if(no==null){
            return;
        }
        postOrder(no.left);
        System.out.print(no.num);
        postOrder(no.right);

    }
}
