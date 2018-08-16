package hard;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int currentCount;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;
        map = new HashMap<>();
        currentCount = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    private void moveToHead(Node node) {
        node.pre = node.next;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    private void deleteNode() {
        tail.pre = tail.pre.pre;
        tail.pre.pre.next = tail;
        tail.pre.next = null;
        tail.pre.pre = null;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            if (currentCount == capacity) {
                deleteNode();
                currentCount--;
                map.remove(tail.pre.key);
            }
            Node node = new Node();
            node.key = key;
            node.value = value;
            moveToHead(node);
            currentCount++;
            map.put(key, node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

    }

    private static class Node {
        int key;
        int value;
        Node pre;
        Node next;
    }

}
