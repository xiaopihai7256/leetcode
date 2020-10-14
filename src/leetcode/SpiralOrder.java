package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * date: 2020/10/13
 * description: SpiralOrder
 * @author xiaopihai7256
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] m = {
                {1,2},
                {7,8}
        };
        System.out.println(spiralOrder(m));
    }

    /**
     * https://leetcode-cn.com/problems/spiral-matrix/submissions/
     * 54. 螺旋矩阵
     * @param matrix 矩阵
     * @return 结果
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);
        spiralOrder(result, matrix, 0, 0, 0);
        return result;
    }

    /**
     * 根据起点坐标，按照方向遍历迭代边界上/边界内元素
     * @param result 返回结果集合
     * @param matrix 原始矩阵
     * @param x 纵向起点坐标
     * @param y 横向起点坐标
     * @param direction 方向 dir%3 -> 0 从左往右，1 从上往下， 2 总右往左，3 从下往上
     */
    public static void spiralOrder(List<Integer> result, int[][] matrix, int x, int y, int direction) {
        int border = (direction + 1) / 4;
        switch (direction % 4) {
            case 0:
                for (; y < matrix[0].length - border; y++) {
                    result.add(matrix[x][y]);
                }
                if (x + 1 >= matrix.length - border) {
                    return;
                } else {
                    spiralOrder(result, matrix, ++x, --y, ++direction);
                }
                break;
            case 1:
                for (; x < matrix.length - border; x++) {
                    result.add(matrix[x][y]);
                }
                if (y - 1 < border) {
                    return;
                } else {
                    spiralOrder(result, matrix, --x, --y, ++direction);
                }
                break;
            case 2:
                for (; y >= border; y--) {
                    result.add(matrix[x][y]);
                }
                if (x - 1 <= border) {
                    return;
                } else {
                    spiralOrder(result, matrix, --x, ++y, ++direction);
                }
                break;
            default:
                for (; x >= border; x--) {
                    result.add(matrix[x][y]);
                }
                if (y + 1 < matrix[0].length - border) {
                    spiralOrder(result, matrix, ++x, ++y, ++direction);
                }
        }
    }

}
