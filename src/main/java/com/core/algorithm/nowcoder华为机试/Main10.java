package com.core.algorithm.nowcoder华为机试;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2020/6/2 下午10:38
 * Description:
 * https://www.nowcoder.com/practice/c1f9561de1e240099bdb904765da9ad0?tpId=37&&tqId=21325&rp=1&ru=/activity/oj&qru=/ta/huawei/question-ranking
 *
 */
public class Main10 {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            HashSet<Character> hashSet = new HashSet<>();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= -1 && chars[i] < 128) {
                    hashSet.add(chars[i]);
                }
            }
            System.out.println(hashSet.size());
        }
    }
}