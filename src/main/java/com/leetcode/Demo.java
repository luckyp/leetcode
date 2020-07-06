package com.leetcode;

import java.util.Calendar;

public class Demo {

    public static void main(String[] args) {
        double r = buy(6, 9, 102);
        System.out.println(r);

    }

    private static double buy (int lowLevel, int highLevel, double lowPrice) {

        int n = highLevel - lowLevel;

        return lowPrice * (Math.pow(2, n));

    }
}

