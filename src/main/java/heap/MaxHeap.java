package heap;

import java.util.Arrays;
import java.util.Collections;

public class MaxHeap<T extends Comparable<T>> implements IHeap<T> {
    transient String a;
    T[] data; // 배열로 구현하면 부모나 자식 노드의 위치 찾기가 수월함
    int size;
    int maxSize; // 최대 사이즈

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.data = (T[]) new Comparable[maxSize + 1];// 0번째 인덱스는 비워야 함, Comparable 인터페이스를 구현한 객체
        this.size = 0;
    }

    private int parent(int pos) {
        return pos >> 1; // pos 의 부모노드의 위치, pos / 2
    }

    private int leftChild(int pos) {
        return pos << 1; // pos * 2
    }

    private int rightChild(int pos) {
        return (pos << 1) + 1; // pos * 2 + 1
    }

    private boolean isLeaf(int pos) {
        // pos 위치의 노드가 leaf 인지
        return (pos > (size >> 1) && pos <= size); // pos > (size / 2) && ...
    }

    @Override
    public void insert(T val) {
        this.data[++this.size] = val;
        int current = this.size;
        while (this.data[parent(current)] != null &&
               this.data[current].compareTo(this.data[parent(current)]) > 0) {
            Collections.swap(Arrays.asList(this.data), current, parent(current));
            current = parent(current);
        }
    }

    @Override
    public boolean contains(T val) {
        for (int i = 1; i < this.size; i++) {
            if (val.equals(this.data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T pop() {
        T top = this.data[1];

        this.data[1] = this.data[this.size--];

        heapify(1);

        return top;
    }

    private void heapify(int idx) {
        if (isLeaf(idx)) return;

        T currnet = this.data[idx];
        T left = this.data[leftChild(idx)];
        T right = this.data[rightChild(idx)];

        if (currnet.compareTo(left) < 0 ||
            currnet.compareTo(right) < 0) {
            if (left.compareTo(right) > 0) {
                Collections.swap(Arrays.asList(this.data), idx, leftChild(idx));
            } else {
                Collections.swap(Arrays.asList(this.data), idx, rightChild(idx));
                heapify(idx);
            }
        }
    }

    @Override
    public T peek() {
        if (this.size < 1)
            return null;
//            throw new RuntimeException();
        return this.data[1];
    }

    @Override
    public int size() {
        return this.size;
    }
}
