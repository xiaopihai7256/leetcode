package leetcode;

import java.util.Arrays;

/**
 * FindMedianSortedArrays
 *
 * Date: 2019-07-27
 * Description: 寻找中位数
 */

public class FindMedianSortedArrays {


    /**
     * 1,2,3,4,6,7,8
     * 3,6,7,8,12,15,17
     * k = 7; a,b = 0
     * i = k/2 => 3;
     * ia = i + a - 1 =  2;
     * ib = i + b - 1 =  2;
     * 1,2,3 and 3,6,7 -> 3 < 7 --> a = ia + 1 == 3;
     * <p>
     * k = k - i = 4;
     * i = k / 2 = 2;
     * ia = i + a - 1 =  4;  6
     * ib = i + b - 1 =  1;  6
     * 6 == 6 , a = ia + 1 = 5;
     * <p>
     * k = k - i = 2;
     * i = k / 2 = 1;
     * ia = i + a -1 = 5;
     * ib = i + b - 1 = 0;
     * 7, 3 = 7 > 3 ==> b = ib + 1 = 1;
     * <p>
     * k = k - i = 1;
     * i = k / 2 = 0;
     * <p>
     * <p>
     * a = 3, b = 0;
     * 4, 3 => 4 > 3 ==> b + k = 1;
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 5};
        int[] nums5 = {1, 2};
        int[] nums6 = {-1, 3};
        int[] nums7 = {2};
        int[] nums8 = {1, 3, 4, 5, 6, 7};
        int[] nums9 = {2};
        int[] nums10 = {1, 3, 4, 5, 6, 7, 8};
        int[] nums11 = {3};
        int[] nums12 = {-2, -1};
        asserted(nums7, nums8, 4);
        asserted(nums9, nums10, 4.5);
        asserted(nums11, nums12, -1);

        int[] nums13 = {2};
        int[] nums14 = {1, 3, 4};
        asserted(nums13, nums14, 2.5);

        int[] nums15 = {2};
        int[] nums16 = {-5, -3, -1};
        asserted(nums15, nums16, -2);

        int[] nums17 = {1, 3};
        int[] nums18 = {2, 4, 5, 6, 7, 8};
        asserted(nums17, nums18, 4.5);


        int[] nums19 = {4};
        int[] nums20 = {1, 2, 3, 5};
        asserted(nums19, nums20, 3);

        int[] nums21 = {2, 3};
        int[] nums22 = {1, 4, 5};
        asserted(nums21, nums22, 3);

        int[] nums23 = {5, 6};
        int[] nums24 = {1, 2, 3, 4, 7};
        asserted(nums23, nums24, 4);

        int[] nums25 = {6};
        int[] nums26 = {1, 2, 3, 4, 5, 7, 8};
        asserted(nums25, nums26, 4.5);

        int[] nums27 = {5};
        int[] nums28 = {1, 2, 3, 4, 6, 7, 8, 9};
        asserted(nums27, nums28, 5);


    }

    static boolean asserted(int[] nums1, int[] nums2, double answer) {
        System.out.println();
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        double result;
        try {
            result = findMedianSortedArrays(nums1, nums2);
        } catch (Exception e) {
            System.out.println("Error. " + "Nil = " + answer);
            e.printStackTrace();
            return false;
        }
        if (result == answer) {
            System.out.println("Right. " + result + " = " + answer);
            return false;
        } else {
            System.out.println("Wrong! " + result + " != " + answer);
            return false;
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int nums1L = nums1.length;
        int nums2L = nums2.length;
        // 其中一个为空的情况
        if (nums1L == 0 && nums2L != 0) {
            return sortedArrayMid(nums2, nums2L);
        } else if (nums1L != 0 && nums2L == 0) {
            return sortedArrayMid(nums1, nums1L);
        }

        // 两个都不为空的情况, 但是连续
        if (nums1[nums1L - 1] <= nums2[0]) {
            return sortedArrayMid(nums1, nums2);
        } else if (nums2[nums2L - 1] <= nums1[0]) {
            return sortedArrayMid(nums2, nums1);
        }
        // 常规情况
        int total = nums1L + nums2L; // 总数
        int half = total / 2; // 一半
        int a = 0, b = 0; // 索引记录
        boolean odd = total % 2 == 1; // 总和是否为奇数
        int k = odd ? half + 1 : half; // 要寻找的目标索引
        int i; // 迭代索引增量 总是为k的一半, 可以理解为k的二分查找
        while ((i = k / 2) != 0) {
            int ia = a + i - 1;
            int ib = b + i - 1;
            if (ia > nums1L - 1) {
                ia = nums1L - 1;
            }
            if (ib > nums2L - 1) {
                ib = nums2L - 1;
            }
            if (nums1[ia] < nums2[ib]) {
                if (ia + 1 == nums1L) {
                    a = ia;
                    break;
                } else {
                    a = ia + 1;
                }
            } else if (nums1[ia] > nums2[ib]) {
                if (ib + 1 == nums2L) {
                    b = ib;
                    break;
                } else {
                    b = ib + 1;
                }
            } else if (a >= b) {
                if (ia + 1 == nums1L) {
                    a = ia;
                    break;
                } else {
                    a = ia + 1;
                }
            } else {
                if (ib + 1 == nums2L) {
                    b = ib;
                    break;
                } else {
                    b = ib + 1;
                }
            }
            k = k - i;
        }
        int numa = nums1[a];
        int numb = nums2[b];
        // k != 1 说明迭代没有走完，提前截断了
        if (k != 1) {
            if (odd) {
                if (a == nums1L - 1) {
                    return nums2[half - nums1L];
                } else {
                    return nums1[half - nums2L];
                }
            }
            if (a == nums1L - 1) {
                int x = nums2[half - nums1L - 1];
                int y = nums2[half - nums1L];
                if (numa <= x || numa >= y) {
                    return ((double) x + y) / 2;
                } else {
                    return (double) (numa + y) / 2;
                }
            } else {
                int x = nums1[half - nums2L - 1];
                int y = nums1[half - nums2L];
                if (numb <= x || numb >= y) {
                    return ((double) x + y) / 2;
                } else {
                    return (double) (numb + y) / 2;
                }
            }
        } else if (odd) {
            return Math.min(numa, numb);
        } else {
            boolean aLess = numa < numb;
            int mid = aLess ? numa : numb;
            int other;
            if (aLess) {
                other = a + 1 >= nums1L ? numb : Math.min(nums1[a + 1], numb);
            } else {
                other = b + 1 >= nums2L ? numa : Math.min(numa, nums2[1 + b]);
            }
            return ((double) other + mid) / 2;
        }
    }

    static double avg(int a, int b) {
        return ((double) a + b) / 2;
    }

    /**
     * 单个集合有值的情况下
     *
     * @param nums1  集合
     * @param nums1L 集合长度
     * @return 中位数
     */
    static double sortedArrayMid(int[] nums1, int nums1L) {
        if (nums1L % 2 == 0) {
            int mid = nums1L / 2;
            return ((double) (nums1[mid - 1] + nums1[mid])) / 2;
        } else {
            return nums1[nums1L / 2];
        }
    }

    /**
     * 两个集合直接拼接有序的情况, 算法复杂度
     *
     * @param nums1 前序集合
     * @param nums2 后序集合
     * @return 中位数
     */
    static double sortedArrayMid(int[] nums1, int[] nums2) {
        int nums1L = nums1.length;
        int nums2L = nums2.length;
        int total = nums1L + nums2L;
        int half = total / 2;
        if (total % 2 == 1) {
            if (nums1L <= half) {
                return nums2[half - nums1L];
            } else {
                return nums1[half];
            }
        }
        if (nums1L > half) {
            return avg(nums1[half], nums1[half - 1]);
        } else if (nums1L < half) {
            int start = half - nums1L;
            return avg(nums2[start], nums2[start - 1]);
        } else {
            return avg(nums1[nums1L - 1], nums2[0]);
        }
    }
}
