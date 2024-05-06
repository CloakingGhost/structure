package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1655 {
    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //min heap : 집합 B
        PriorityQueue<Integer> min = new PriorityQueue<>();
        //max heap : 집합 A
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < N; i++){
            int x = sc.nextInt();
            // 숫자를 부를 때마다 연산

            if(max.size() == min.size()){
                max.offer(x);
            } else {
                min.offer(x);
            }
            if (!min.isEmpty() && max.peek() > min.peek()) {
                min.offer(max.poll());
                max.offer(min.poll());
            }

            result.append(max.peek());
            result.append("\n");
        }
        System.out.println(result);
    }
}
