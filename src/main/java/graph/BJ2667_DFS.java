package graph;

import java.util.*;

public class BJ2667_DFS {
    //첫줄에서는 정사각형의 크기 N
    //두번째부터 자료 N 줄 * N개
    // 대각이 아닌 사방위에 1이 있을때 연결로 판단
    // 단지의 총 수와 단지 별 집의 수 출력
    static int[][] direction = {
            //좌 우 하 상 {x ,y}
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    static int size = 0;

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]){
                    size = 1;
                    dfs(N, map, visited, i, j);
                    result.add(size);
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        result.forEach(i -> System.out.println(i));
//        result.forEach(System.out::println);
    }

    public static void dfs(int N, int[][] map, boolean[][] visited, int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < direction.length; i++) {
            int nX = x + direction[i][0];
            int nY = y + direction[i][1];
            if (nX >= 0 && nY >= 0 && nX < N && nY < N && map[nX][nY] == 1 && !visited[nX][nY]) {
                size += 1;
                dfs(N, map, visited, nX, nY);

            }
        }
    }
}
