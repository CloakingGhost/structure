package queue;


public class MyCircularQueue<T> implements IQueue<T> {

    private T[] elements;
    private int front;
    private int rear;
    private int maxSize;

    public MyCircularQueue(int size) {
        this.maxSize = size + 1;
        this.elements = (T[]) new Object[maxSize];
        this.front = 0;
        this.rear = 0;

    }

    @Override
    public void offer(T data) {
        if (this.isFull()) {
            throw new IllegalStateException();
        }
        this.rear += 1;
        this.elements[this.rear % this.maxSize] = data;

    }

    @Override
    public T poll() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        this.front += 1;
        return this.elements[this.front % this.maxSize];
    }

    @Override
    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        return this.elements[++this.front];
    }

    @Override
    public int size() {
        if (this.front <= this.rear) {
            return this.rear - this.front;
        }
        return this.maxSize - this.front + this.rear;

    }

    @Override
    public void clear() {
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public boolean isFull() {
        return (++this.rear) % this.maxSize == this.front;
    }
}
