package medium.heap;

import java.util.PriorityQueue;

/**
 * 这个问题，两个答案，看不懂：https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
 */
public class KthSmallest {
    /**
     * beat:46%
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int big = m * m - k + 1;//这里不要忘记加1
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(big);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (priorityQueue.size() < big) {
                    priorityQueue.offer(matrix[i][j]);
                } else if (priorityQueue.peek() < matrix[i][j]) {
                    priorityQueue.poll();
                    priorityQueue.offer(matrix[i][j]);
                }
            }
        }
        return priorityQueue.peek();
    }


    public int kthSmallestBetterHeap(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int j = 0; j <= n - 1; j++) pq.offer(new Tuple(0, j, matrix[0][j])); //将第一行放入pq
        for (int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll(); // 取出最小的
            if (t.x == n - 1) continue;
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;

    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }
}
