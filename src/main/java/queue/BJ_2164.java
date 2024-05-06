package queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        br.close();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.offer(i + 1);
        }
        byte count = 0;
        while (queue.size() > 1) {
            int q = queue.poll();
            if (count == 1) {
                queue.offer(q);
                count--;
                continue;
            }
            count++;
        }
        bw.write(String.valueOf(queue.peek()));
        bw.flush();
        bw.close();
    }
}
