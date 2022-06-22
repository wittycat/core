package com.core.algorithm.nowcoder.华为机试;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by chenxun.
 * Date: 2020/6/2 下午10:38
 * Description:
 * https://www.nowcoder.com/practice/eb94f6a5b2ba49c6ac72d40b5ce95f50?tpId=37&&tqId=21233&rp=1&ru=/activity/oj&qru=/ta/huawei/question-ranking
 *
 */
public class Main102 {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            HashMap<Character, Integer> hashMap = new HashMap<>();
            int[] arr = new int[128];
            char[] chars = line.toCharArray();
            int max = 0;
            for (int i = 0; i < chars.length; i++) {
                if (('z' >= chars[i] && chars[i] >= 'a') || ('Z' >= chars[i] && chars[i] >= 'A') || ('9' >= chars[i] && chars[i] >= '0') || (' ' >= chars[i])) {
                    arr[chars[i]]++;
                    if (arr[chars[i]] > max) {
                        max = arr[chars[i]];
                    }
                }
            }

            while (max > 0) {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == max) {
                        System.out.print((char) i);
                    }
                }
                max--;
                if (max == 0) {
                    System.out.println();
                }
            }
        }

    }
}