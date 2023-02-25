import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class MyNode{
    int data;
    MyNode left;
    MyNode right;
}
class Tree{
    public MyNode root;

    public void setRoot(MyNode node){
        this.root=root;
    }
    public MyNode getRoot(){
        return root;
    }

    public MyNode addNode(MyNode left, int data, MyNode right ){
        MyNode node = new MyNode();
        node.data=data;
        node.left=left;
        node.right=right;
        return node;
    }
}


public class Tree_11725 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[n+1];

    }
}
