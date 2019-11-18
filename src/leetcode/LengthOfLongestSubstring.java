package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * maxUniqLengthOfStr
 *
 * Date: 2019-06-16
 * Description: 最长的重复子串
 */

public class LengthOfLongestSubstring {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("我爱我家"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndex = new HashMap<>(s.length());
        int start =0, maxLength = 0, length = 0;
        for (int i =0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            Integer lastIndex = charIndex.get(ch);
            if (Objects.nonNull(lastIndex) && charIndex.get(ch) >= start) {
                start = lastIndex + 1;
                length = i - start + 1;
            } else {
                length += 1;
            }
            maxLength = length > maxLength ? length : maxLength;
            charIndex.put(ch, i);
        }
        return maxLength;
    }
}
