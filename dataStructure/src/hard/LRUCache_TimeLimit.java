package hard;


import java.util.*;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before
 * inserting a new item.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache_TimeLimit cache = new LRUCache_TimeLimit(2);
 * <p>
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LRUCache_TimeLimit {
    private PriorityQueue<CacheValue> priorityQueue;
    private int capacity;
    private long flag = 0;

    public LRUCache_TimeLimit(int capacity) {
        this.capacity = capacity;
        priorityQueue = new PriorityQueue<>(new Comparator<CacheValue>() {
            @Override
            public int compare(CacheValue o1, CacheValue o2) {
                return Long.compare(o1.comp, o2.comp);
            }
        });
    }

    public int get(int key) {
        Iterator<CacheValue> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            CacheValue cacheValue = iterator.next();
            if (cacheValue.key == key) {
                cacheValue.comp = ++flag;
                update();
                return cacheValue.value;
            }
        }
        return -1;
    }

    private void update() {

//        int size = priorityQueue.size();
//        for (int i = 0; i < size; i++) {
//            priorityQueue.offer(priorityQueue.remove());
//        }


        CacheValue[] list = new CacheValue[priorityQueue.size()];
        Iterator<CacheValue> iterator = priorityQueue.iterator();
        int j = 0;
        while (iterator.hasNext()) {
            list[j] = iterator.next();
            j++;
        }
        priorityQueue.clear();
        for (int i = 0; i < list.length; i++) {
            priorityQueue.offer(list[i]);
        }
    }

    Map<Integer, CacheValue> map = new HashMap<>();

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            CacheValue cache = map.get(key);
            cache.value = value;
            cache.comp = ++flag;
            update();
            return;
        }
        if (priorityQueue.size() == capacity) {
            priorityQueue.remove();
        }
        CacheValue cacheValue = new CacheValue(key, value, ++flag);
        map.put(key, cacheValue);
        priorityQueue.offer(cacheValue);
    }

    public static void main(String[] args) {
        LRUCache_TimeLimit cache = new LRUCache_TimeLimit(2);
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

    static class CacheValue {
        int key;
        int value;
        long comp;

        public CacheValue(int key, int value, long comp) {
            this.key = key;
            this.value = value;
            this.comp = comp;
        }

        @Override
        public String toString() {
            return
                    "key=" + key +
                            ", value=" + value +
                            ", comp=" + comp +
                            '}';
        }
    }

}
