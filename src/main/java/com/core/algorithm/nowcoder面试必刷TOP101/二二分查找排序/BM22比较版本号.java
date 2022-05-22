package com.core.algorithm.nowcoder面试必刷TOP101.二二分查找排序;

/**
 * Created by chenxun.
 * Date: 2022/5/14 11:42 AM
 * Description:
 */
public class BM22比较版本号 {

    public static void main(String[] args) {
        int compare = compare("1.1","1.01");
        System.out.println(compare);
    }

    public static int compare (String version1, String version2) {
        char[] chars = version1.toCharArray();
        char[] chars2 = version2.toCharArray();
        int i=0,j=0;
        while (i<chars.length || j<chars2.length){
            int num1 = 0;
            while (i<chars.length&& chars[i]!='.'){
                num1 = num1*10+(chars[i]-'0');
                i++;
            }
            i++;

            int num2 = 0;
            while (j<chars2.length&& chars2[j]!='.'){
                num2 = num2*10+(chars2[j]-'0');
                j++;
            }
            j++;

            if(num1>num2){
                return 1;
            }
            if(num1<num2){
                return -1;
            }
        }
        return 0;
    }
}