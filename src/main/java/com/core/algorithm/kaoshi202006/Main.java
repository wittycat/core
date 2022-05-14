package com.core.algorithm.kaoshi202006;

/**
 * Created by chenxun.
 * Date: 2020/7/22 下午3:05
 * Description:
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextDouble()) {
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();

            ArrayList<Double> nums = new ArrayList<>();
            nums.add(a);
            nums.add(b);
            nums.add(c);

            Collections.sort(nums);

            Double max = nums.get(2);
            Double middle = nums.get(1);
            Double min = nums.get(0);
            Double i = max * max;
            Double j = middle * middle + min * min;
            if (i .equals(j)) {
                System.out.println("直角三角形");
            }
            if (i < j) {
                System.out.println("锐角三角形");
            }
            if (i > j) {
                System.out.println("钝角三角形");
            }

        }
    }
}