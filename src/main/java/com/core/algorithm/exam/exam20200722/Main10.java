package com.core.algorithm.exam.exam20200722;

/**
 * Created by chenxun.
 * Date: 2020/7/22 下午3:05
 * Description:
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] s = line.split(" ");

            ArrayList<Integer> nums = new ArrayList<>();
            nums.add(Integer.parseInt(s[0]));
            nums.add(Integer.parseInt(s[1]));
            nums.add(Integer.parseInt(s[2]));

            Collections.sort(nums);

            Integer max = nums.get(2);
            Integer middle = nums.get(1);
            Integer min = nums.get(0);
            int i = max * max;
            int j = middle * middle + min * min;
            if (i == j) {
                System.out.println("直角三角形");
            }
            if (i < j) {
                System.out.println("钝角三角形");
            }
            if (i > j) {
                System.out.println("锐角三角形");
            }
        }
    }
}