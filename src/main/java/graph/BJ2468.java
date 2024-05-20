package graph;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BJ2468 {
    static int[][] direction = {
            {0, -1}, {1, 0}, {0, 1}, {-1, 0}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int[][] area = new int[N][N];
        int maxHeight = 1;
        for (int i = 0; i < N; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                int h = Integer.parseInt(s[j]);
                area[i][j] = h;
                maxHeight = Math.max(h, maxHeight);
            }
        }
        int result1 = 1;
        int result2 = 1;
        for (int h = 1; h <= maxHeight; h++) {
            boolean[][] visited1 = new boolean[N][N];
            boolean[][] visited2 = new boolean[N][N];
            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (area[i][j] > h && !visited1[i][j]) {
                        //조건문을 통과했다는 것은 찾고자 한 영역에 들어왔다는 의미
                        count1++; // bfs 로 visited 세팅하고 여기서 각 포인트 확인
                        bfs(h, N, area, visited1, i, j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (area[i][j] > h && !visited2[i][j]) {
                        //조건문을 통과했다는 것은 찾고자 한 영역에 들어왔다는 의미
                        count2++; // dfs 로 visited 세팅하고 여기서 각 포인트 확인
                        dfs(h, N, area, visited2, i, j);
                    }
                }
            }
            result1 = Math.max(count1, result1);
            result2 = Math.max(count2, result2);
        }
        System.out.println(result1);
        System.out.println(result2);
    }

    private static void bfs(int h, int N, int[][] area, boolean[][] visited, int x, int y) {
        //메소드가 실행 됐다는 것은 위 조건문을 통과했으므로
        visited[x][y] = true;

        //visited 세팅
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y}); //탐색 시작위치 삽입

        while (!q.isEmpty()) {
            int[] coordinate = q.poll();
            for (int[] d : direction) {
                int nX = d[0] + coordinate[0];
                int nY = d[1] + coordinate[1];
                if (nX >= 0 && nY >= 0 && nX < N && nY < N
                    && area[nX][nY] > h && !visited[nX][nY]) {
                    q.add(new int[]{nX, nY});
                    visited[nX][nY] = true;
                }
            }
        }

    }

    private static void dfs(int h, int N, int[][] area, boolean[][] visited, int x, int y) {
        visited[x][y] = true;

        Stack<int[]> s = new Stack<>();
        s.push(new int[]{x, y});

        while (!s.isEmpty()) {
            int[] coordinate = s.pop();
            for (int[] d : direction) {
                int nX = coordinate[0] + d[0];
                int nY = coordinate[1] + d[1];

                if (nX >= 0 && nY >= 0 && nX < N && nY < N
                    && area[nX][nY] > h && !visited[nX][nY]) {
                    s.push(new int[]{nX, nY});
                    visited[nX][nY] = true;
                }
            }
        }

    }
}
