package com.core.algorithm.amoscloud2022;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by chenxun.
 * Date: 2022/6/16 11:55 AM
 * Description:
 */
public class 题目84 {
    /**
     *   小组中每位都有一张卡片
     *   卡片是6位以内的正整数
     *   将卡片连起来可以组成多种数字
     *   计算组成的最大数字
     *
     *   输入描述：
     *     ","分割的多个正整数字符串
     *     不需要考虑非数字异常情况
     *     小组种最多25个人
     *
     *    输出描述：
     *      最大数字字符串
     *
     *    示例一
     *      输入
     *       22,221
     *      输出
     *       22221
     *
     *     示例二
     *       输入
     *         4589,101,41425,9999
     *       输出
     *         9999458941425101
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> collect1 = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());
        Integer length = collect1.stream().map(item -> item.length()).sorted(Comparator.reverseOrder()).findFirst().get();

        List<Map.Entry<String, Integer>> list = collect1.stream().map(item -> {
            String temp = item;
            for (int i = item.length(); i < length; i++) {
                temp=temp+"9";
            }
            Map<String, Integer> map = Collections.singletonMap(item, Integer.parseInt(temp));
            return map.entrySet().iterator().next();
        }).sorted((o1, o2) -> o2.getValue() - o1.getValue()).collect(Collectors.toList());
        String res = "";
        for (int i = 0; i < list.size(); i++) {
            res = res + list.get(i).getKey();
        }

        System.out.println(res);
    }
}