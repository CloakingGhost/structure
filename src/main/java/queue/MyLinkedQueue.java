package queue;

import list.Node;

public class MyLinkedQueue<T> implements IQueue<T> {

    private Node head;
    private Node tail;
    private int size;

    MyLinkedQueue() {
        this.size = 0;
        this.head = new Node(null);
        this.tail = this.head;

    }

    @Override
    public void offer(T data) {

        Node node = new Node(data);
        this.tail.next = node;
        this.tail = this.tail.next;
        this.size++;

    }

    @Override
    public T poll() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        Node node = this.head.next;
        this.head.next = node.next;
        node.next = null;
        this.size--;
        if (this.isEmpty()) {
            this.tail = this.head;
        }
        return (T) node.data;
    }

    @Override
    public T peek() {if (this.isEmpty()) {
        throw new IllegalStateException();
    }
        return (T) this.head.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.head.next = null;
        this.tail = this.head;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }
}
