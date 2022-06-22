package com.core.algorithm.nowcoder.华为机试;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chenxun.
 * Date: 2020/6/2 下午10:38
 * Description:
 * https://www.nowcoder.com/practice/e45e078701ab4e4cb49393ae30f1bb04?tpId=37&&tqId=21235&rp=1&ru=/activity/oj&qru=/ta/huawei/question-ranking
 *
 */
public class Main12 {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            char[] chars = line.toCharArray();
            int i = 0, j = chars.length - 1;
            while (j > i) {
                char istr = chars[i];
                chars[i] = chars[j];
                chars[j] = istr;
                ++i;
                --j;
            }

            System.out.println(new String(chars));
        }
        reader.close();
    }
}