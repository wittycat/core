package com.core.algorithm.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chenxun.
 * Date: 2020/6/2 下午10:38
 * Description:
 * https://www.nowcoder.com/practice/5190a1db6f4f4ddb92fd9c365c944584?tpId=37&tqId=21249&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tPage=2
 *
 */
public class Main26 {

    /**
     * 字符和int运算会先把字符转化为数字
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            char[] chars = line.toCharArray();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 'A'; i <= 'Z'; i++) {
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] == i || chars[j] == (i + 32)) {
                        stringBuffer.append(chars[j]);
                    }
                }
            }
            for (int i = 0; i < chars.length; i++) {
                if ((chars[i] >= 'A' && chars[i] <= 'Z') || (chars[i] >= 'a' && chars[i] <= 'z')) {

                } else {
                    stringBuffer.insert(i, chars[i]);
                }
            }
            System.out.println(stringBuffer.toString());
        }
        reader.close();
    }
}