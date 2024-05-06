package graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

//제네릭 타입을 작성하지 않은 이유
//int 타입으로만 사용하여 이해에 초점을 맞춤
public interface IGraph {
    void add(int from, int to, Integer distance);// 출발 노드, 도착 노드, 가중치

    void add(int from, int to);// 출발 노드, 도착 노드

    Integer getDistance(int from, int to);// 가중치를 가져오는 메소드

    // Map<버텍스 번호, 차수의 수>
    Map<Integer, Integer> getIndegrees();// 그래프 상의 모든 버텍스의 대하여 들어오는 edge 의 개수를 Map 으로 가져옴

    // 모든 버텍스
    Set<Integer> getVertexes();

    // 해당 버텍스로 부터 나가는 버텍스의 집합(리스트)
    List<Integer> getNodes(int vertex);
}
