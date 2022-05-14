package com.core.algorithm.nowcoder;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by chenxun.
 * Date: 2020/6/2 下午10:38
 * Description:
 * https://www.nowcoder.com/profile/121472/codeBookDetail?submissionId=1519346
 *
 */
public class Main3 {

    /**
     * 方式二：创建1000大小的数组，根据角标放置，输出
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            TreeSet<Integer> set = new TreeSet();
            for (int i = 0; i < num; i++) {
                int curr = sc.nextInt();
                set.add(curr);
            }
            set.stream().forEach(integer -> System.out.println(integer));
        }
    }
}