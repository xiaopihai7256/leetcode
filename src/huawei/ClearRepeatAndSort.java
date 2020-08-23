package huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * date: 2020/8/23
 * description: 清除重复的元素，并排序
 *
 * @author xiaopihai7256
 */
public class ClearRepeatAndSort {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numStr;
        while((numStr = br.readLine()) != null){
            int size = Integer.parseInt(numStr);
            int[] numbers = new int[size];
            for(int i = 0; i < size; i++){
                numbers[i] = Integer.parseInt(br.readLine());
            }
            int result = clearAndSort(numbers);
            for(int i=0;i<result;i++){
                System.out.println(numbers[i]);
            }

        }
    }

    public static int clearAndSort(int[] array) {
        Arrays.sort(array);
        int i = 1, j =1;
        for (; j < array.length; j++) {
            if (array[i - 1] != array[j]) {
                array[i] = array[j];
                i++;
            }
        }
        return i;
    }



}
