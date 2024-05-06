package list;

public class MyDoubleLinkedList<T> implements IList<T> {
    private Node head;
    private Node tail;
    private int size;

    MyDoubleLinkedList() {
        this.size = 0;
        this.head = new Node(null);
        this.tail = new Node(null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    @Override
    public void add(T t) {
        Node last = this.tail.prev;
        Node node = new Node(t, last, this.tail);
        last.next = node;
        this.tail.prev = node;
        this.size++;

    }

    @Override
    public void insert(int index, T t) {
        Node prev, curr;
        int i = 0;
        if (index < this.size / 2) {
            prev = this.head;
            curr = prev.next;
            while (i++ < index) {
                prev = prev.next;
                curr = curr.next;
            }
        } else {
            curr = this.tail;
            prev = curr.prev;
            while (i++ < this.size - index) {
                curr = curr.next;
                prev = prev.next;
            }
        }
        Node node = new Node(t, prev, curr);
        prev.next = node;
        curr.prev = node;
        this.size++;
    }


    @Override
    public void clear() {
        this.size = 0;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    @Override
    public boolean delete(T t) {
        Node currFromHead = this.head.next;
        Node currFromTail = this.tail.prev;
        int index = 0;
        while (index++ < (this.size - 1) / 2) {
            if (currFromHead != null && currFromHead.data.equals(t)) {
                currFromHead.prev.next = currFromHead.next;
                currFromHead.next.prev = currFromHead.prev;
                currFromHead.next = null;
                currFromHead.prev = null;
                this.size--;
                return true;
            } else if (currFromTail != null && currFromTail.data.equals(t)) {
                currFromTail.prev.next = currFromTail.next;
                currFromTail.next.prev = currFromTail.prev;
                currFromTail.next = null;
                currFromTail.prev = null;
                this.size--;
                return true;
            }
            assert currFromHead != null;
            currFromHead = currFromHead.next;
            assert currFromTail != null;
            currFromTail = currFromTail.prev;
        }

        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        Node prev, curr, next;

        int i = 0;
        if (index < this.size / 2) {
            prev = this.head;
            curr = prev.next;
            while (i++ < index) {
                prev = prev.next;
                curr = curr.next;
            }
            prev.next = curr.next;
            curr.next.prev = prev;
        } else {
            next = this.tail;
            curr = next.prev;
            while (i++ < this.size - 1 - index) {
                next = next.prev;
                curr = curr.prev;
            }
            next.prev = curr.prev;
            curr.prev.next = next;
        }
        curr.next = null;
        curr.prev = null;
        this.size--;
        return true;
    }

    @Override
    public T get(int index) {
        int i = 0;
        Node curr = null;
        if (index < this.size / 2) {
            curr = this.head.next;
            while (i++ < index) {
                curr = curr.next;
            }
        } else {
            curr = this.tail.prev;
            while (i++ < this.size - 1 - index) {
                curr = curr.prev;
            }
        }
        return (T) curr.data;
    }

    @Override
    public int indexOf(T t) {
        Node currFromHead = this.head.next;
        Node currFromTail = this.tail.prev;
        int index = 0;
        while (index < (this.size - 1) / 2) {
            if (currFromHead.data.equals(t)) {
                return index;
            } else if (currFromTail.data.equals(t)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(T t) {
        Node currFromHead = this.head.next;
        Node currFromTail = this.tail.prev;
        int index = 0;
        while (index++ < (this.size - 1) / 2) {
            if (currFromHead.data.equals(t)) {
                return true;
            } else if (currFromTail.data.equals(t)) {
                return true;
            }
            currFromHead = currFromHead.next;
            currFromTail = currFromTail.prev;
        }
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }
}
