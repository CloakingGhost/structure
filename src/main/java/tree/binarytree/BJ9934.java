package tree.binarytree;

import java.util.*;

public class BJ9934 {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);

        //트리의 노드 개수
        int K = (int) Math.pow(2, sc.nextInt()) - 1;

        List<Integer> l = new ArrayList<>() {{
            for (int i = 0; i < K; i++) {
                add(sc.nextInt());
            }
        }};
        Node root = buildTree(l, 0, l.size() - 1);
        printTree(root);
    }


    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static void printTree(Node root) {
        StringBuilder sb = new StringBuilder();

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node node = q.poll();
                sb.append(node.data);
                sb.append(" ");
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void printT(Node root) {
        StringBuilder answer = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {

            int n = q.size();
            for (int i = 0; i < n; n++) {
                Node node = q.poll();
                answer.append(node.data);
                answer.append(" ");
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);

            }
            answer.append("\n");
        }
    }

    // 루트 노드 색출
    static Node buildTree(List<Integer> inorder, int start, int end) {
        if (start > end) return null; // 노드의 값이 null 이 됨

        //중간 인덱스
        int i = start + ((end - start) / 2);
        Node node = new Node(inorder.get(i)); //root node

        if (start == end) {// 리프 노드 도달
            return node; // 함수 종료
        }

        node.left = buildTree(inorder, start, i - 1);
        node.right = buildTree(inorder, i + 1, end);
        return node;
    }

    static Node bt(List<Integer> inorders, int start, int end) {
        if (start > end) return null;

        int i = start + ((end - start) / 2);
        Node node = new Node(inorders.get(i));

        if (start == end)
            return node;

        node.left = bt(inorders, start, i - 1);
        node.right = bt(inorders, i + 1, end);

        return node;
    }
}
