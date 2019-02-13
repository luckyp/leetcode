package com.leetcode;

import java.util.*;

/**
 * 强整数
 * <p>
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 */
public class Q802 {


    public static void main(String[] args) {
        Q802 q802 = new Q802();

        int x = 4, y = 40, bound = 100;

        long t1 = System.currentTimeMillis();

        List lst = q802.powerfulIntegers(x, y, bound);
        System.out.println(Arrays.toString(lst.toArray()));
        long t2 = System.currentTimeMillis();

        System.out.println(t2 - t1);

    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        Set<Integer> rs = new HashSet<>();

        if (x == 1 && y == 1) {
            if (bound >= 2) {
                rs.add(2);
            }
        } else {
            int i = 0;
            int j = 0;

            for (; ; i++) {

                int r1;
                for (; ; j++) {

                    r1 = pow(x, i) + pow(y, j);

                    if (r1 <= bound) {
                        if (!rs.contains(r1)) {
                            rs.add(r1);
                        }
                    } else {
                        j = 0;
                        break;
                    }

                    if (j > bound) {
                        j = 0;
                        break;
                    }
                }

                r1 = pow(x, i) + pow(y, j);

                if (r1 > bound) {
                    break;
                }

                if (i > bound) {
                    break;
                }
            }

        }

        return new ArrayList<>(rs);
    }

    private Integer pow(int x, int i) {

        return (int) Math.pow(x, i);
    }

}
