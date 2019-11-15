package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * KeyNumbers
 *
 * 提供五个条件，要求推断出符合该条件的数字
 *
 * @author huifei.liu@hand-chian.com
 * Date: 2019-06-16
 * Description: 找出符合条件的数字
 */

public class KeyNumbers {

    private static int[] condition1 = {6,8,2};
    private static int[] condition2 = {6,1,4};
    private static int[] condition3 = {2,0,6};
    private static int[] condition4 = {7,3,8};
    private static int[] condition5 = {8,7,0};

    public static void main(String[] args) {

        Function<Integer, int[]> split = num -> String.format("%03d", num).chars().map(i -> i - '0').toArray();
        IntStream.range(0, 999)
                .boxed()
                .map(split)
                .filter(KeyNumbers::condition1)
                .filter(KeyNumbers::condition2)
                .filter(KeyNumbers::condition3)
                .filter(KeyNumbers::condition4)
//                .filter(KeyNumbers::condition5)
                .findAny()
                .map(Arrays::toString)
                .ifPresent(System.out::println);

    }



    /**
     * 6-8-2: 一个号码正确，且位置正确
     */
    public static boolean condition1(int[] numbers) {
        int[] arr = contains(condition1, numbers);
        if (arr.length != 1) {
            return false;
        }
        int num = arr[0], index = indexOf(numbers, arr[0]);
        // test condition 1
        return num == KeyNumbers.condition1[index]
                && num == numbers[index];
    }

    /**
     * 6-1-4: 一个号码正确, 但是位置不正确
     */
    public static boolean condition2(int[] numbers) {
        int[] arr = contains(condition2, numbers);
        if (arr.length != 1) {
            return false;
        }
        int num = arr[0], index = indexOf(numbers, arr[0]);
        return index != indexOf(condition2, num);
    }

    /**
     * 2-0-6: 两个号码正确，位置不正确
     */
    public static boolean condition3(int[] numbers) {
        int[] arr = contains(condition3, numbers);
        if (arr.length != 2) {
            return false;
        }
        int num1 = arr[0], index1 = indexOf(numbers, arr[0]);
        int num2 = arr[1], index2 = indexOf(numbers, arr[1]);
        return index1 != indexOf(KeyNumbers.condition3, num1)
                && index2 != indexOf(KeyNumbers.condition3, num2);
    }

    /**
     * 7-3-8: 都不正确
     */
    public static boolean condition4(int[] numbers) {
        int[] arr = contains(condition4, numbers);
        return arr.length == 0;
    }

    /**
     * 8-7-0: 一个号码正确，但是位置不正确
     */
    public static boolean condition5(int[] numbers) {
        int[] arr = contains(condition5, numbers);
        if (arr.length != 1) {
            return false;
        }
        int num = arr[0], index = indexOf(numbers, arr[0]);
        return index != indexOf(KeyNumbers.condition5, num);
    }

    public static int[] contains(int[] array, int ...number) {
        List<Integer> result = new ArrayList<>();
        for (int a : array) {
            for (int b : number) {
                if (a == b) {
                    result.add(a);
                }
            }
        }
        int[] arr = new int[result.size()];
        int count = 0;
        for (int num : result) {
            arr[count] = num;
            count++;
        }
        return arr;

    }

    public static int indexOf(int[] arr, int num) {
        for(int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
