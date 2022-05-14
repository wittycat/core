package com.core.algorithm.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chenxun.
 * Date: 2020/6/2 下午10:38
 * Description:
 * https://www.nowcoder.com/practice/440f16e490a0404786865e99c6ad91c9?tpId=37&&tqId=21238&rp=1&ru=/activity/oj&qru=/ta/huawei/question-ranking
 *
 */
public class Main15 {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            int i = Integer.parseInt(line);
            String s = Integer.toBinaryString(i);
            char[] chars = s.toCharArray();
            int count = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '1') {
                    count++;
                }
            }
            System.out.println(count);
        }
        reader.close();
    }
}