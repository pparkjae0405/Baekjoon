import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 루트 노드를 입력한다.
        Node root = new Node(Integer.parseInt(br.readLine()));

        // 2. 다음 입력이 없을 때 까지 반복하여
        while(true){
            String s = br.readLine();
            if(s == null || s.equals("")) break;

            // 노드를 입력받아 추가하고
            root.insert(Integer.parseInt(s));
        }

        // 3. 모두 입력한 다음 후위순회한다.
        postOrder(root);

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node{
        int num;
        Node left;
        Node right;

        public Node(int num){
            this.num = num;
        }
        public Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        void insert(int n){
            if(n < this.num){
                if(this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            }else{
                if(this.right == null) this.right=new Node(n);
                else this.right.insert(n);
            }
        }
    }

    static void postOrder(Node node){
        if(node==null) return;
        postOrder(node.left); //왼쪽 순회
        postOrder(node.right); //오른쪽 순회
        System.out.println(node.num);
    }
}