package base.dynamicprogramming;

public class Knapsack01 {
    private static int[] weight = {1, 5, 9, 2, 4, 8, 10};
    private static int[] value = {5, 3, 2, 7, 9, 8, 6};
    private static final int MAX_PUT_WEIGHT = 20;
    private static final int COUNT = weight.length;

    /**
     * 递归法
     * 时间复杂度为2的n次方,n为item的个数
     *
     * @param weight
     * @param value
     * @param maxCap
     * @return
     */
    public static int maxValue1(int[] weight, int[] value, int maxCap) {
        return inner(weight, value, maxCap, COUNT - 1);
    }

    private static int inner(int[] weight, int[] value, int maxCap, int pointer) {
        if (pointer == -1) {
            return 0;
        }
        if (maxCap == 0) {
            return 0;
        }
        //attention 丢了这个条件 必须加上这个，因为当大于剩余容量时根本就不能放进去
        if (weight[pointer] > maxCap) {
            return inner(weight, value, maxCap, pointer - 1);
        }
        //对于第n个item，有两种选择，放或者不放，求出最大值即可
        return Math.max(value[pointer] + inner(weight, value, maxCap - weight[pointer], pointer - 1),
                inner(weight, value, maxCap, pointer - 1));
    }


    /**
     * 时空复杂度均为 COUNT  * MAX_PUT_WEIGHT
     * 时间复杂度不能再优化，空间复杂度还可以再优化
     *
     * @param weight
     * @param value
     * @param maxCap
     * @return
     */
    public static int maxValue_memo(int[] weight, int[] value, int maxCap) {
        // attention 这个table二维数组不容易想出来,相当于new int[第i个item][在这个item可能剩余的容量]
        int[][] table = new int[COUNT][maxCap];
        for (int i = 0; i < COUNT; i++) {
            for (int j = 0; j < maxCap; j++) {
                table[i][j] = -1;
            }
        }
        return inner_memo(table, weight, value, maxCap, weight.length - 1);
    }

    private static int inner_memo(int[][] memo, int[] weight, int[] value, int maxCap, int pointer) {
        if (pointer == -1) {
            return 0;
        }
        if (maxCap == 0) {
            return 0;
        }
        //attention 丢了这个条件 必须加上这个，因为当大于剩余容量时根本就不能放进去
        if (weight[pointer] > maxCap) {
            return inner(weight, value, maxCap, pointer - 1);
        }
        //最多经过   初始的item个数 * MAX_PUT_WEIGHT  次就全部都存储了所有的情况，直接从数组取就好了
        if (memo[pointer][maxCap - 1] != -1) {
            return memo[pointer][maxCap];
        }
        int result = Math.max(value[pointer] + inner(weight, value, maxCap - weight[pointer], pointer - 1),
                inner(weight, value, maxCap, pointer - 1));
        memo[pointer][maxCap - 1] = result;
        return result;
    }

    //自底向上的不是很好思考
//    public static int maxValue_bottom_up(int[] weight, int[] value, int maxCap) {
//        int[][] table = new int[COUNT][maxCap];
//        for (int i = 0; i < COUNT; i++) {
//            for (int j = 0; j < maxCap; j++) {
//
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println(maxValue1(weight, value, MAX_PUT_WEIGHT));
        System.out.println(maxValue_memo(weight, value, MAX_PUT_WEIGHT));
    }
}
