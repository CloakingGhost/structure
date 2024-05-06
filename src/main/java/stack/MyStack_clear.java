package stack;

import list.Node;

public class MyStack_clear<T> implements IStack<T> {

    private int size;
    private Node head;

    MyStack_clear() {
        this.size = 0;
        this.head = new Node(null);
    }

    @Override
    public void push(T data) {
        Node node = new Node(data, this.head.next);
        this.head.next = node;
        this.size++;

    }

    @Override
    public T pop() {
        if (this.isEmpty()) {
            return null;
        }
        Node curr = this.head.next;
        this.head.next = curr.next;
        curr.next = null;
        this.size--;
        return (T) curr.data;
    }

    @Override
    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return (T) this.head.next.data;
    }

    private boolean isEmpty() {
        return this.head.next == null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
