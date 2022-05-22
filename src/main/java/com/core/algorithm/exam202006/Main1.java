package com.core.algorithm.exam202006;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2020/6/7 下午2:55
 * Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int k = Integer.parseInt(scanner.nextLine());
            String str = scanner.nextLine();
            String[] split = str.split("-");
            String index0Str = split[0];
            String newStr = String.copyValueOf(str.toCharArray(),index0Str.length(),str.length()-index0Str.length())
                    .replace(index0Str, "").replace("-", "");
            char[] chars = newStr.toCharArray();
            int i = 0;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(index0Str);
            while (i < chars.length) {
                stringBuffer.append("-");
                int end = (i + k) < chars.length ? (i + k) : chars.length;
                char[] copyOfRange = Arrays.copyOfRange(chars, i, end);
                change(copyOfRange);
                stringBuffer.append(copyOfRange);
                i = end;
            }
            System.out.println(stringBuffer.toString());
        }
    }

    private static void change(char[] chars) {
        int  small = 0;
        int  big = 0;
        for (int i = 0; i < chars.length ; i++) {
            if('z'>=chars[i]&&chars[i]>='a'){
                small++;
            }
            if('Z'>=chars[i]&&chars[i]>='A'){
                big++;
            }
        }
        if(small>big){
            for (int i = 0; i < chars.length ; i++) {
                if('Z'>=chars[i]&&chars[i]>='A'){
                    chars[i] = (char)(chars[i]+32);
                }
            }
        }
        if(small<big){
            for (int i = 0; i < chars.length ; i++) {
                if('z'>=chars[i]&&chars[i]>='a'){
                    chars[i] = (char)(chars[i]-32);
                }
            }
        }
    }
}