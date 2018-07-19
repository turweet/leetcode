package cc150.arraystring;

import org.junit.Test;

/**
 * 题目描述
 * <p>
 * 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
 * <p>
 * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
 * 测试样例：
 * <p>
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],3
 * <p>
 * 返回：[
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 */
public class Transform {
    // TODO: 18/07/2018 需要继续完善，画图分析
    public int[][] transformImage(int[][] mat, int n) {
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i; j++) {
                int temp = mat[i][j];//存储左边
                mat[i][j] = mat[n - i - 1][j]; //下边到左边
                mat[n - i - 1][j] = mat[n - i - 1][n - j - 1];//右边到下边
                mat[n - i - 1][n - j - 1] = mat[i][n - j - 1]; //上边到右边
                mat[i][n - j - 1] = temp;
            }
        }
        return mat;
    }
    @Test
    public void test() {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        transformImage(arr, 3);
    }
}
