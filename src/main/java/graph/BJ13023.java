package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ13023 {
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int N = Integer.parseInt(s.split(" ")[0]); // 버텍스 수
        int M = Integer.parseInt(s.split(" ")[1]); // 엣지 수
        List<List<Integer>> graph = new ArrayList<>() {{
            for (int i = 0; i < N; i++) {
                add(i, new ArrayList<>());
            }
        }};

// 양방향 그래프
        for (int i = 0; i < M; i++) {
            String r = sc.nextLine();

            int a = Integer.parseInt(r.split(" ")[0]);
            int b = Integer.parseInt(r.split(" ")[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);

        }
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            int depth = 1;
            dfs(graph, visited, i, depth);

            if (found) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);

    }

    static void dfs(List<List<Integer>> graph, boolean[] visited, int v, int depth) {
        if (depth == 5) {
            found = true;
            return;
        }
        visited[v] = true;

        for (int vertex : graph.get(v)) {
            if (!visited[vertex]) {
                dfs(graph, visited, vertex, depth + 1);
            }
        }
        visited[v] = false; // 핵심, 방문한 곳을 다시 방문하여 연결된 버텍스틑 탐색할 수 있게 한다
    }
}
