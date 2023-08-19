import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 이진 트리 노드의 개수 N이 주어지고, 새 트리를 선언한다.
        int N = Integer.parseInt(br.readLine());
        Tree t = new Tree();

        // 2. 각 노드와 그의 왼쪽, 오른쪽 자식 노드가 주어지고 노드 정보를 저장한다.
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            t.createNode(root, left, right);
        }

        // 3. 트리 순회를 통해 전위, 중위, 후위 순회 결과를 출력한다.
        t.preOrder(t.root);
        System.out.println();
        t.inOrder(t.root);
        System.out.println();
        t.postOrder(t.root);

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node{
        // 노드 값, 왼쪽, 오른쪽 자식 노드 참조값
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
        }
    }

    static class Tree{
        public Node root;

        // 값을 추가하는 메서드
        public void createNode(char data, char leftData, char rightData){
            // 초기상태면 루트 노트 생성
            if(root == null){
                root = new Node(data);

                // 좌우 값이 있으면 노드 생성
                if(leftData != '.'){
                    root.left = new Node(leftData);
                }
                if(rightData != '.'){
                    root.right = new Node(rightData);
                }
            }else{
                // 초기상태가 아니라면 data에 해당하는 노드를 찾아야함
                searchNode(root, data, leftData, rightData);
            }
        }

        // 값을 어느 위치에 추가할지 찾는 메서드
        public void searchNode(Node node, char data, char leftData, char rightData){
            // root 노드부터 data와 같은 값을 가진 노드를 찾아 내려가는데
            if(node == null){
                // null이면 찾을 노드 X
                return;
            }else if(node.data == data){
                // 들어갈 위치를 찾았다면
                // 좌우 값이 있으면 노드 생성
                if(leftData != '.'){
                    node.left = new Node(leftData);
                }
                if(rightData != '.'){
                    node.right = new Node(rightData);
                }
            }else{
                // 찾지 못했으면 왼쪽, 오른쪽 재귀 탐색
                searchNode(node.left, data, leftData, rightData);
                searchNode(node.right, data, leftData, rightData);
            }
        }

        // 전위순회 메서드
        public void preOrder(Node node){
            if(node != null){
                System.out.print(node.data);
                if(node.left != null){
                    preOrder(node.left);
                }
                if(node.right != null){
                    preOrder(node.right);
                }
            }
        }

        // 중위순회 메서드
        public void inOrder(Node node){
            if(node != null){
                if(node.left != null){
                    inOrder(node.left);
                }
                System.out.print(node.data);
                if(node.right != null){
                    inOrder(node.right);
                }
            }
        }

        // 후위순회 메서드
        public void postOrder(Node node) {
            if (node != null) {
                if (node.left != null) {
                    postOrder(node.left);
                }
                if (node.right != null) {
                    postOrder(node.right);
                }
                System.out.print(node.data);
            }
        }
    }
}