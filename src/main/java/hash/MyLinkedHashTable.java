package hash;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedHashTable<K, V> implements IHashTable<K, V> {
    //Hash충돌 시 LinkedList 체이닝으로 해결
    //값을 저장할 Node class 만들기
    //테이블에서 실제로 데이터를 저장하게될 bucket field 필요함

    private static final int DEFAULT_BUCKET_SIZE = 1024;

    private List<Node>[] buckets; // 배열은 배열인데 List를 담는 배열, 체이닝 구현을 위함
    private int bucketSize;
    private int size; //table의 크기

    public MyLinkedHashTable() {
        this.buckets = new List[DEFAULT_BUCKET_SIZE]; // 현재 원소는 null
        this.bucketSize = DEFAULT_BUCKET_SIZE;
        this.size = 0;

        //buckets 초기화
        for (int i = 0; i < bucketSize; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    public MyLinkedHashTable(int bucketSize) {
        this.buckets = new List[bucketSize]; // 현재 원소는 null
        this.bucketSize = bucketSize;
        this.size = 0;

        //buckets 초기화
        for (int i = 0; i < bucketSize; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    @Override
    public void put(K key, V value) {
        int idx = this.hash(key);
        List<Node> bucket = this.buckets[idx];

        //key가 있으면 value로 업데이트
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                node.data = value;
                return;
            }
        }
        Node node = new Node(key, value);
        bucket.add(node);
        this.size++;

    }

    @Override
    public V get(K key) {
        int idx = this.hash(key);
        List<Node> bucket = this.buckets[idx];//LinkedList
        for (Node node : bucket) { // key의 해시값이 같은 노드들 중에 key를 확인
            if (node.key.equals(key)) {
                return node.data;
            }
        }
        //없을 때
        return null;
    }

    @Override
    public boolean delete(K key) {
        int idx = this.hash(key);
        List<Node> bucket = this.buckets[idx];
        for (Iterator<Node> iter = bucket.iterator(); iter.hasNext(); ) {
            Node node = iter.next();
            if (node.key.equals(key)) {
                iter.remove();
                this.size--;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean contains(K key) {
        int idx = this.hash(key);
        List<Node> bucket = this.buckets[idx];
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    //핵심 기능 hash method(function)
    //low level의 자바 파이썬 런타임 시 사용되는 방법
    private int hash(K key) {
        int hash = 0;
        //
        for (char ch : key.toString().toCharArray()) {
            hash += (int) ch;
        }

        // bucket size 보다 작게만든다
        // 왜? bucket에 담을 때 인덱스로 활용할 것이기 때문
        return hash % this.bucketSize;
    }

    private class Node {
        K key;
        V data;

        Node(K key, V data) {
            this.key = key;
            this.data = data;
        }
    }
}
