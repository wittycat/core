package com.core.algorithm.nowcoder面试必刷TOP101.h八字符串;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by chenxun.
 * Date: 2022/5/21 4:01 PM
 * Description:
 */
public class BM84最长公共前缀 {
    public static String longestCommonPrefix (String[] strs) {
        if(strs==null){
            return null;
        }
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        List<Integer> size = Arrays.stream(strs).map(String::length).sorted().collect(Collectors.toList());

        List<char[]> collect = Arrays.stream(strs).map(String::toCharArray).collect(Collectors.toList());

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size.get(0); i++) {
            char c1 = collect.get(0)[i];
            boolean allsame= true;
            for (int j = 1; j <collect.size() ; j++) {
                char c = collect.get(j)[i];
                if(c1!=c){
                    allsame = false;
                }
            }
            if(allsame){
                stringBuilder.append(c1);
            }else {
                return stringBuilder.toString();
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] a = {"abca","abc","abca","abc","abcc"};
        System.out.println(longestCommonPrefix(a));
    }
}