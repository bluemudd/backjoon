//public class sample {
//        static boolean []check;
//        static int maxW =0;
//        static int maxH =0;
//        static int result = Integer.MAX_VALUE;
//        public static void main(String[] args) {
//            int [][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
//            int answer = 0;
//            check = new boolean[sizes.length];
//            for(int i=0; i<sizes.length; i++){
//                dfs(sizes, i, 0, 0);
//                System.out.println("---------------------");
//            }
//            System.out.println(result);
//        }
//        public static void dfs(int[][] sizes, int depth, int count, int index){
//            if(count == depth){
//                for(int j=0; j<sizes.length; j++){
//                    System.out.print("("+sizes[j][0]+","+sizes[j][1]+")");
//                }
//
//                for(int i=0; i<sizes.length; i++){
//                    maxW=Math.max(sizes[i][0], maxW);
//                    maxH=Math.max(sizes[i][1], maxH);
//
//                }
//                System.out.println("depth: "+depth+" index: "+index+"("+maxH+","+maxW+")");
//                result=Math.min(result,maxW*maxH);
//                System.out.println("result:"+result);
//                return;
//            }
//
//            int swap = sizes[index][0];
//            sizes[index][0] = sizes[index][1];
//            sizes[index][1] = swap;
//            count++;
//            System.out.println("count:"count)
//            for(int i=0; i <sizes.length; i++){
//                if(check[i]) continue;
//                check[index] = true;
//                dfs(sizes, depth, count, i);
//                check[index]= false;
//            }
//        }
//    }
