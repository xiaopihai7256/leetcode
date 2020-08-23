package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * date: 2020/8/23
 * description: FintCharInString
 *
 * @author xiaopihai7256
 */
public class FindCharInString {

    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine().toLowerCase();
            char ch = scan.nextLine().toLowerCase().charAt(0);
            System.out.println(countChar(str, ch));
        }
    }


    public static int countChar(String str, char ch) {
        int count = 0 ;
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }

}
