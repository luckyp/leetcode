package com.leetcode;

import java.util.Arrays;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Created by yanpeng on 2017/2/10.
 */
public class Q1 {
    public static void main(String[] args) {

        int[] nums = {3 ,2, 7, 11, 15};
        int target = 13;
        Q1 q1 = new Q1();
        System.out.println(Arrays.toString(q1.twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no solution");
    }
}
