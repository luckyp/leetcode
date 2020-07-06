package com.leetcode.array;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = {2};
        int[] nums2 = {1};

        MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
        double d = m.findMedianSortedArrays(nums1, nums2);
        System.out.println(d);

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int quotient = (m + n) / 2;
        int remainder = (m + n) % 2;

        int i1 = 0;
        int i2 = 0;

        double result = 0;

        while (i1 < m || i2 < n) {

            Integer a = null;
            Integer b = null;

            int cur = 0;

            if (i1 < m) {
                a = nums1[i1];
            }

            if (i2 < n) {
                b = nums2[i2];
            }

            if (a == null && b == null) {
                throw new IllegalArgumentException("no result");
            } else if (a == null) {
                cur = b;
                i2 ++;
            } else if (b == null) {
                cur = a;
                i1 ++;
            } else {
                if (a < b && i1 != m) {
                    cur = a;
                    i1++;
                } else {
                    cur = b;
                    i2++;
                }
            }

            if (remainder == 0) {
                // 偶数个 取 总长度/2 -1  & 总长度/2
                if (i1 + i2 == quotient) {
                    result = cur;
                }

                if (i1 + i2 == quotient + 1) {
                    result += cur;
                    result = result / 2;
                    break;
                }
            } else {
                // 奇数个，取中间数
                if (i1 + i2 == quotient + 1) {
                    result = cur;
                    break;
                }
            }
        }

        return result;
    }
}
