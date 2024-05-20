package graph;

import java.util.*;
import java.util.stream.Collectors;

// 위상정렬
public class BJ14567 {

    static class Pair {
        final Integer subject; // 과목 번호
        final Integer semester; // 학기

        public Pair(Integer subject, Integer semester) {
            this.subject = subject;
            this.semester = semester;
        }
    }

    public static void main(String[] args) {
//        input
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int N = Integer.parseInt(s.split(" ")[0]); // 전체 과목 수
        int M = Integer.parseInt(s.split(" ")[1]); // 선수 과목 조건의 수

        // 인덱스는 과목 번호와 매핑
        // index -> 과목번호(0, 과목번호 1): 0 인덱스에 1번 과목
        // value -> 선수 과목의 개수
        int[] indegree = new int[N];

        // 그래프화
        // <from, List<to>>
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < M; i++) {
            s = sc.nextLine();
            // A 과목은 B 과목의 선수 과목, A -> B 방향
            int A = Integer.parseInt(s.split(" ")[0]); //from
            int B = Integer.parseInt(s.split(" ")[1]); //to

            indegree[B - 1] += 1;
            List<Integer> l = graph.getOrDefault(A, new ArrayList<>());
            l.add(B);
            graph.put(A, l);
        }
        sc.close();

        Queue<Pair> queue = new LinkedList<>();
        // 과목 번호는 1부터
        for (int i = 1; i <= indegree.length; i++) {
            if (indegree[i - 1] == 0) {
                queue.add(new Pair(i, 1));
            }
        }


        Integer[] result = new Integer[N];
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            result[p.subject - 1] = p.semester;

            if (graph.containsKey(p.subject)) {
                for (Integer node : graph.get(p.subject)) {
                    indegree[node - 1] -= 1;
                    if (indegree[node - 1] == 0) {
                        queue.add(new Pair(node, p.semester + 1));
                    }
                }
            }
        }
        System.out.println(
                Arrays.stream(result)
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))
        );

    }
}
