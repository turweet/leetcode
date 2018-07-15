package base.dynamicprogramming.bag9;

//有 N 件物品和一个容量为 V 的背包。放入第 i 件物品耗费的费用是 Ci1，得到的 价值是 Wi。求解将哪些物品装入背包可使价值总和最大。

/**
 * 这个问题其实和切割钢条的问题是一样的{@link base.dynamicprogramming.SteelTripe} 钢条的长度对应容量，每段钢条对应所占空间和价值
 */
public class bag1 {
    public static final int V = 20;//容量
    public static final int[][] weight_value = {{3, 5}, {8, 6}, {9, 10}, {2, 13}, {7, 6}}; //第一个数字代表耗费的费用Ci，第二个代表价值Wi

    /**
     * 这是最基础的背包问题，特点是:每种物品仅有一件，可以选择放或不放。
     用子问题定义状态:即 F [i, v] 表示前 i 件物品恰放入一个容量为 v 的背包可以获得 的最大价值。则其状态转移方程便是:
     F[i,v] = max{F[i − 1,v],F[i − 1,v − Ci] + Wi}
     这个方程非常重要，基本上所有跟背包相关的问题的方程都是由它衍生出来的。所 以有必要将它详细解释一下
     :“将前 i 件物品放入容量为 v 的背包中”这个子问题，若 只考虑第 i 件物品的策略(放或不放)，
     那么就可以转化为一个只和前 i − 1 件物品相关 的问题。如果不放第 i 件物品，那么问题就转化为“前 i − 1 件物品放入容量为 v 的背 包中”，
     价值为 F [i − 1, v];如果放第 i 件物品，那么问题就转化为“前 i − 1 件物品放 入剩下的容量为v−Ci 的背包中”，
     此时能获得的最大价值就是F[i−1,v−Ci]再加上 通过放入第 i 件物品获得的价值 Wi。
     伪代码如下:
     F[0,0..V] ←0
     fori ←1toN
        forv ←Ci toV
            F[i,v] ← max{F[i − 1,v],F[i − 1,v − Ci] + Wi}
     * @param capacity
     * @param weight_value
     * @return
     */


}
