package com.leetcode.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 */
public class SearchInsert {

    public static void main(String[] args) {
        SearchInsert s = new SearchInsert();

        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(s.searchInsert2(nums, target));
        ;
    }

    public int searchInsert(int[] nums, int target) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            if (i == 0 && target < nums[i]) {
                index = i;
                break;
            }
            if (target > nums[nums.length - 1]) {
                index = nums.length;
                break;
            }

            if (nums[i] == target) {
                index = i;
                break;
            }
            if (target < nums[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int searchInsert2(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                right = mid - 1;
            }
        }

        if (left == 0) {
            return 0;
        }

        if (right == nums.length - 1) {
            if (target == nums[right]) {
                return right;
            }
            return right + 1;
        }

        return 0;
    }
}
