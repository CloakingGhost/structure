package list;

 public class Node {
    public Object data;
    public Node prev;
    public Node next;

    public Node(Object data) {
        this.data = data;

    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;

    }

    public Node(Object data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;

    }

}
