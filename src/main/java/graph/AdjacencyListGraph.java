package graph;

import java.util.*;

public class AdjacencyListGraph implements IGraph {

    private List<List<Node>> graph;// 인덱스는 버텍스의 시작점, 시작점이 가리키는 도착점과 가중치를 담은 노드(버텍스) 리스트
    private Set<Integer> vertexes;
    private Map<Integer, Integer> indegrees;

    public AdjacencyListGraph(int numOfVertex) {
        this.vertexes = new HashSet<>();
        this.indegrees = new HashMap<>();
        this.graph = new ArrayList<>(numOfVertex);
        for (int i = 0; i < numOfVertex; i++) {
            this.graph.add(new ArrayList<>());
        }
    }

    @Override
    public void add(int from, int to, Integer distance) {
        //Set 이므로 중복 제거 됨
        vertexes.add(from); // 시작점 삽입
        vertexes.add(to); // 도착점 삽입

        int count = indegrees.getOrDefault(to, 0);// 도착점의 차수
        indegrees.put(to, count + 1);// 도착점에 차수에 1 추가

        List<Node> neighbors = this.graph.get(from);// 시작점의 리스트
        neighbors.add(new Node(from, to, distance));// 시작점에서 도착점까지 거리(가중치)값 삽입, 중복 허용(만약 방향까지 넣는다면 중복은 막을 수 있을 듯?)
    }

    @Override
    public void add(int from, int to) {
        vertexes.add(from);
        vertexes.add(to);

        int count = indegrees.getOrDefault(to, 0);
        indegrees.put(to, count + 1);

        List<Node> neighbors = this.graph.get(from);
        neighbors.add(new Node(from, to));
//        neighbors.add(new Node(to, from));// 양방향
    }

    @Override
    public Integer getDistance(int from, int to) {
        for (Node node : this.graph.get(from)) {
            if (node.to.equals(to)) {
                return node.weight;
            }
        }
        return null;
    }

    @Override
    public Map<Integer, Integer> getIndegrees() {
        return this.indegrees;
    }

    @Override
    public Set<Integer> getVertexes() {
        return this.vertexes;
    }

    @Override
    public List<Integer> getNodes(int vertex) {
        List<Integer> nodes = new ArrayList<>();
        for (Node node : this.graph.get(vertex)) {
            nodes.add(node.to);
        }
        return nodes;
    }

    private class Node {
        Integer from;
        Integer to;
        int weight;

        Node(int from, int to) {
            this.from = from;
            this.to = to;
            this.weight = 1;
        }

        Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
