package com.core.algorithm.amoscloud2022;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2022/6/17 5:04 PM
 * Description:
 */
public class 题目73 {
    /**
     *   给出一个只包含字母的字符串,
     *     不包含空格,统计字符串中各个子字母(区分大小写)出现的次数,
     *     并按照字母出现次数从大到小的顺序输出各个字母及其出现次数
     *     如果次数相同,按照自然顺序排序,且小写字母在大写字母之前
     *
     *     输入描述:
     *       输入一行仅包含字母的字符串
     *
     *     输出描述:
     *       按照字母出现次数从大到小的顺序输出各个字母和字母次数,
     *       用英文分号分割,
     *       注意末尾的分号
     *       字母和次数中间用英文冒号分隔
     *
     *     示例:
     *         输入: xyxyXX
     *         输出:x:2;y:2;X:2;
     *     说明:每个字符出现的次数为2 故x排在y之前
     *     而小写字母x在大写X之前
     *
     *     示例2:
     *         输入:
     *          abababb
     *         输出:
     *             b:4;a:3
     *         说明:b的出现个数比a多 故排在a前
     */

    public static void main(String[] args) {
        //    97:a 122:z   65:A  90:Z
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] all = new int[123];
        for (int i = 0; i < line.length(); i++) {
            int index = line.charAt(i);
            all[index] += 1;
        }

        List<Demo> list = new ArrayList<>();
        int priority = 100;
        for (int i = 97; i <= 122; i++) {
            if (all[i] > 0) {
                list.add(new Demo((char) i, all[i], priority));
                priority--;
            }
        }
        for (int i = 65; i <= 90; i++) {
            if (all[i] > 0) {
                list.add(new Demo((char) i, all[i], priority));
                priority--;
            }
        }

        String[] demos = list.stream().sorted(new Comparator<Demo>() {
            @Override
            public int compare(Demo o1, Demo o2) {
                if (o1.count != o2.count) {
                    return o2.count - o1.count;
                } else {
                    return o2.priority - o1.priority;
                }
            }
        }).map(demo -> demo.c + ":" + demo.count).toArray(String[]::new);
        System.out.println(String.join(";", demos));
    }

    static class Demo{
        char c;
        int count;
        int priority;

        public Demo(char c, int count, int priority) {
            this.c = c;
            this.count = count;
            this.priority = priority;
        }
    }
}