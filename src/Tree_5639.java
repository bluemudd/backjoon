import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tree_5639 {
    static class Node{
        int num;
        Node left;
        Node right;

        Node(int n){
            this.num=n;
        }
        Node(int n, Node left, Node right){
            this.num=n;
            this.left=left;
            this.right=right;
        }
        void insert(int n){
            if(n<this.num){
                if(this.left == null){this.left=new Node(n);}
                else{this.left.insert(n);}
            }
            else{
                if(this.right == null){this.right=new Node(n);}
                else{this.right.insert(n);}
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Node root = new Node(Integer.parseInt(input));
        while(true){
            input = br.readLine();
            if (input == null){
                break;
            }
            if(input.equals("")){
                break;
            }
            root.insert(Integer.parseInt(input));
        }
        postOrder(root);
    }
    static void postOrder(Node n){
        if(n==null){
            return;
        }
        postOrder(n.left);
        postOrder(n.right);
        System.out.println(n.num);
    }
}