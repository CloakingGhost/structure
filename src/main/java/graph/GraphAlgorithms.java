package graph;

import queue.IQueue;
import queue.MyLinkedQueue;
import stack.IStack;
import stack.MyStack;

import java.util.*;

public class GraphAlgorithms {

    // 파라미터: 그래프 타입, 시작노드
    // 방문한 노드를 순서대로 저장하고 반환
    public static List<Integer> bfs(IGraph iGraph, int from) {
        // 방문한 노드 저장용
        List<Integer> result = new ArrayList<>();
        // 방문했던 노드를 재방문하지 않기 위해서 Set 사용
        Set<Integer> visited = new HashSet<>();
        // 방문할 노드 저장용
        Queue<Integer> queue = new LinkedList<>();
        //시작위치
        queue.add(from);
        // 큐에 넣었다는 것은 방문한다는 것이므로 재방문하지않기 위해 넣어준다
        visited.add(from);

        while (!queue.isEmpty()) {
            Integer next = queue.poll();
            // 방문한 순서대로 저장
            result.add(next);

            //next에 연결된 노드들을 큐에 넣어준다
            for (Integer n : iGraph.getNodes(next)) {
                // 큐에 넣기 전에 방문했던 노드들인지 확인하고 넣는다
                if (!visited.contains(next)) {
                    queue.add(n);
                    visited.add(n);
                }
            }
            // 반복
        }
        return result;
    }

    //parameter: 그래프, 시작 위치
    //return: 방문한 순저를 저장한 리스트
    public static List<Integer> dfs(IGraph iGraph, int from) {
        //방문한 노드 저장용
        List<Integer> result = new ArrayList<>();
        //방문한 노드 확인용
        Set<Integer> visited = new HashSet<>();
        //방문할 노드 저장용
        IStack<Integer> stack = new MyStack<>();
//        Stack<Integer> stack = new Stack<>(); // Java 에서 지원하는 Stack

        stack.push(from);
        visited.add(from);

        while (stack.size() > 0) {
            // 확인하는 작업들을 여기서 하면 될듯?
            Integer next = stack.pop();
            // 방문한 순서대로 삽입
            result.add(next);

            // 방문한 노드와 연결되어 있는 노드들을 스텍에 추가
            for (Integer n : iGraph.getNodes(from)) {
                if (!visited.contains(n)) {
                    stack.push(n);
                    visited.add(n);
                }
            }
            // 반복
        }

        return result;
    }

//    1. 모든 vertex 의 indegree 수 를 센다
//    2. 큐에 indegree 가 0 인 vertex 삽입
//    3. 큐에서 vertex 를 꺼내 연결된(나가는 방향) edge 제거
//    4. 3번으로 인해 indegree 가 0 이 된 vertex 를 큐에 삽입
//    5. 큐가 빌 때까지 3~4 반복
    public static List<Integer> topologicalSortQueue(IGraph graph) {
        // graph 에서 in-degree 개수를 세어 놨음
        // Map<vertex, indegree 개수>, 각 도착점(vertex)에 대한 in-degree 개수
        Map<Integer, Integer> indegreeCounter = graph.getIndegrees();

        List<Integer> result = new LinkedList<>();
        // in-degree == 0 인 vertex 담음
        IQueue<Integer> queue = new MyLinkedQueue<>();
//        Queue<Integer> queue = new LinkedList<>(); // Java 에서 지원하는 Queue

        // 모든 vertex 자체가 들어있음, 인덱스 같은 vertex 를 간접적으로 찾아가는 정보가 아님
        Set<Integer> vertexes = graph.getVertexes();
        for (Integer v : vertexes) {
            Integer count = indegreeCounter.getOrDefault(v, 0); // null 때문에 0을 넣는 것임
            //in-degree 가 0 인 vertex 담기
            if (count == 0) {
                queue.offer(v); // 삽입
            }
            // 여러개 삽입 될 수 있음, in-degree 가 없는 상태의 vertex 를 모두 담는 작업
        }

        while (!queue.isEmpty()) {
            // 노드 확인
            Integer node = queue.poll();
            result.add(node);

            // 추가 후 out-degree 삭제를 해야하는데 직접 그래프의 간선을 삭제하지 않음
            // 큐에서 가져온 노드와 연결된 노드들을 가져온다, 큐에 담을 다음 노드들임
            for (Integer n : graph.getNodes(node)) {
                //그래프에서 가져온 노드가 카운터에 있으면
                //그 노드의 진입차수 1 감소
                if (indegreeCounter.containsKey(n)) {
                    int count = indegreeCounter.get(n); // 진입차수 가져온다
                    //indegreeCounter 에는 vertex 에 연결된 차수가 있다
                    //이 수를 감소시켰을 때 진입차수가 0 이면 담는다
                    if (count - 1 == 0) {
                        queue.offer(n);
                    }
                    // 1 감소의 의미는 위 node 에 대한 진출차수 1개를 삭제한다 는 것
                    // 진출차수를 감소 했기 때문에 n 입장에선 진입차수 1일 감소 한 꼴
                    indegreeCounter.put(n, --count);
                }
            }
        }


        return result;
    }
    public static List<Integer> topologicalSortStack(IGraph iGraph) {
        return null;
    }
}
