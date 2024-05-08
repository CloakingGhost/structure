package heap;

public class Main {
    public static void main(String[] args) {
        MaxHeap<Integer> h = new MaxHeap<>(5);
        h.insert(3);
        h.insert(1);
        h.insert(2);
        h.insert(5);
        h.insert(4);
//        h.pop();
        System.out.println("h = " + h);
    }
}
