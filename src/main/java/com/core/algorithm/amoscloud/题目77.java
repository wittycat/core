package com.core.algorithm.amoscloud;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2022/6/16 3:05 PM
 * Description:
 */
public class 题目77 {
    /**
     *   双十一众多商品进行打折销售
     *   小明想购买自己心仪的一些物品
     *   但由于购买资金限制
     *   所以他决定从众多心仪商品中购买三件
     *   而且想尽可能得花完资金
     *   现在请你设计一个程序 计算小明尽可能花费的最大资金数
     *
     *   输入描述：
     *     输入第一行为一维整型数组m
     *     数组长度小于100
     *     数组元素记录单个商品的价格
     *     单个商品加个小于1000
     *
     *     输入第二行为购买资金的额度r
     *     r<100000
     *
     *   输出描述：
     *      输出为满足上述条件的最大花费额度
     *
     *    注意：如果不存在满足上述条件的商品请返回-1
     *
     *   示例：
     *      输入
     *       23,26,36,27
     *       78
     *      输出
     *       76
     *      说明：
     *       金额23、26、27得到76而且最接近且小于输入金额78
     *
     *    示例：
     *        输入
     *        23,30,40
     *        26
     *        输出
     *         -1
     *        说明
     *        因为输入的商品无法满足3件之和小于26
     *        故返回-1
     *
     *    输入格式正确无需考虑输入错误情况
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] prices = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).sorted().toArray(Integer[]::new);
        Integer total = Integer.valueOf(scanner.nextLine());

        int cost= buy(prices,total);
        System.out.println(cost);

    }

    private static int buy(Integer[] prices, Integer total) {
        int start = 0;
        int end = 2;

        int res = -1;
        while (end < prices.length) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum = sum + prices[i];
            }
            if (sum <= total) {
                res = sum;
            } else {
                return res;
            }
            start++;
            end++;
        }
        return res;
    }
}