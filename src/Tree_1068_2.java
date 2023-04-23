import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tree_1068_2 {
    static int count = 0;
    static eNode root = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int k = Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine()," ");
        int b = Integer.parseInt(br.readLine());
        int i =0;

        while(st.hasMoreTokens()){
            int a= Integer.parseInt(st.nextToken());
            if(a == -1){
                root = new eNode(i);
            }
            else{
                search(root, a, i);
            }
            i++;
        }
        getRidOf(root,b);
        nodeCount(root);
        System.out.println(count);
    }
    static void search(eNode n , int father, int m){
        if(n == null){
            return;
        }
        else if(n.value == father){
            if(n.left == null){
                n.left=new eNode(m);
            }
            else if(n.right == null){
                n.right = new eNode(m);
            }
        }
        else{
            search(n.left, father, m);
            search(n.right, father, m);
        }
    }
    static void getRidOf(eNode root, int value){
//        System.out.println(root.value+" "+value);
        if(root==null || root.left ==null || root.right ==null){
            return;
        }
        else if(root.value == value){
            root.value = -2;
            root.left=null;
            root.right=null;
        }
        else if(root.left.value == value ){
//            System.out.println(root.left.value);
            root.left=null;
        }
        else if(root.right.value == value){
//            System.out.println(root.right.value);
            root.right=null;
        }
//        else if(root.value==value){
//            System.out.println(root.value);
//            root = null;
//        }
        else {
            getRidOf(root.left, value);
            getRidOf(root.right, value);
        }
    }
    static void nodeCount(eNode root){
        if(root==null){
            return;
        }
        else if(root.value==-2){
            count =0;
        }
        else if(root.left ==null && root.right == null){
//            System.out.print(root.value);
            count++;
        }
        else {
            nodeCount(root.left);
            nodeCount(root.right);
        }
    }
}

class eNode{
    int value;
    eNode left;
    eNode right;

    eNode(int value){
        this.value=value;
    }
    eNode(int value, eNode left, eNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
