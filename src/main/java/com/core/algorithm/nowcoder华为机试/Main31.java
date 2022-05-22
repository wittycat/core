package com.core.algorithm.nowcoder华为机试;

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
public class Main31 {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            char[] chars = line.toCharArray();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < chars.length; i++) {
                if (('z' >= chars[i] && chars[i] >= 'a') || ('Z' >= chars[i] && chars[i] >= 'A')) {
                    stringBuffer.append(chars[i]);
                } else {
                    if (!stringBuffer.toString().endsWith(" ")) {
                        stringBuffer.append(" ");
                    }
                }
            }
            String[] s = stringBuffer.toString().trim().split(" ");
            StringBuffer print = new StringBuffer();
            for (int z = 0; z < s.length; z++) {
                print.append(s[s.length-1-z] + " ");
            }
            System.out.println(print.toString().trim());

        }
        reader.close();
    }
}