package com.core.algorithm.exam20200722;

import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2020/7/22 上午11:08
 * Description:
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int count = in.nextInt();
            int min = 0;
            int max = 0;
            for (int i = 0; i < count ; i++) {
                int number = in.nextInt();
                if(i==0){
                    min = number;
                    max = number;
                }else {
                    if(number<min){
                        min = number;
                    }
                    if(number>max){
                        max = number;
                    }
                }
            }
            System.out.println(max);
            System.out.println(min);
        }
    }
}