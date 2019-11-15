package other;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Demo
 *
 * @author huifei.liu@hand-chian.com
 * Date: 2019/11/12
 * Description: bingo求解
 */

public class Bingo {

    public static void main(String[] args) {
        bingo();
    }

    public static void bingo() {
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        System.out.println("index: " + index);
        for (int i = 0; i < index; i++) {
            int[][] numbers = new int[5][5];
            String[] temp = new String[5];
            String[][] bingo = new String[5][5];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    numbers[j][k] = scanner.nextInt();
                    System.out.print("[" + numbers[j][k] + "]");
                }
            }
            System.out.println("line :" + scanner.nextLine());
            for (int j = 0; j < 5; j++) {
                temp[j] = scanner.nextLine();
                for (int k = 0; k < 5; k++) {

                    bingo[j] = temp[j].split(" ");
                }
            }
            int count = 0;
            int result = 26;
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (bingo[j][k].equals("X")) {
                        continue;
                    }
                    bingo[j][k] = "X";
                    if (isBingoRow(bingo, j)) {
                        set.add(numbers[j][k]);
                    }
                    if (isBingoColumn(bingo, k)) {
                        set.add(numbers[j][k]);
                    }
                    if (j == k && isBingoDiagonal(bingo, 0)) {
                        set.add(numbers[j][k]);
                    }
                    if (j + k == 4 && isBingoDiagonal(bingo, 4)) {
                        set.add(numbers[j][k]);
                    }
                    bingo[j][k] = ".";

                }
            }
            count = set.size();
            for (Integer s : set) {
                if (result > s) {
                    result = s;
                }
            }
            System.out.printf("\n#%d %d %d", i + 1, count, result);
        }
    }

    static boolean  isBingoRow(String[][]  matrix, int rowIndex) {
        for (String str : matrix[rowIndex]) {
            if (!str.equals("X")) {
                return false;
            }
        }
        return true;
    }

    static boolean isBingoColumn(String[][] matrix, int colIndex) {
        for (String[] row : matrix) {
            if (!row[colIndex].equals("X")) {
                return false;
            }
        }
        return true;
    }

    static boolean isBingoDiagonal(String[][] matrix, int x) {
        if (x == 0) {
            for (int i = x; i <= matrix.length ; i++) {
                if (!matrix[i][i].equals("X")) {
                    return false;
                }
            }
        } else {
            for (int i = x; i >= 0 ; i--) {
                if (!matrix[x - i][i].equals("X")) {
                    return false;
                }
            }
        }
        return true;
    }
}
