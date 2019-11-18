package leetcode;

/**
 * IsAnagram
 *
 * Date: 2019/11/13
 * Description: anagram 异形词
 */

public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("adbc", "abcd"));
    }

    public static boolean isAnagram(String s, String t) {
        int sl = s.length(), tl = t.length(), i;
        if (sl != tl) return false;
        int[] hashTable = new int[26];
        for (i = 0; i < sl; hashTable[s.charAt(i++) - 97]++) { }
        for (i--; i >= 0; ) {
            if (--hashTable[t.charAt(i--) - 97] < 0) {
                return false;
            }
        }
        for (i = 0; i < 26; i++) {
            if (hashTable[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
