package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Intersection
 *
 * Date: 2019/11/13
 * Description: 求两数组交集 349
 */

public class Intersection {

    public static int[] intersection(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 == 0 || length2 == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>(length1);
        for (int value : nums1) {
            set1.add(value);
        }
        Set<Integer> result = new HashSet<>(length1);
        for (int value : nums2) {
            if (set1.contains(value)) result.add(value);
        }
        int[] r = new int[result.size()];
        int count = 0;
        for (Integer value : result) {
            r[count++] = value;
        }
        return r;
    }
}
