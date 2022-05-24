package com.core.algorithm.nowcoder面试必刷TOP101.七动态规划;

/**
 * Created by chenxun.
 * Date: 2022/5/23 10:21 PM
 * Description:
 */
public class BM62斐波那契数列 {



    public static int Fibonacci(int n) {
        if(n==1||n==2){
            return 1;
        }
        int i = Fibonacci(n - 2) + Fibonacci(n - 1);
        return i;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(4));;
        System.out.println(Fibonacci(6));;
        System.out.println(Fibonacci(1));;
        System.out.println(Fibonacci(2));;
    }
}