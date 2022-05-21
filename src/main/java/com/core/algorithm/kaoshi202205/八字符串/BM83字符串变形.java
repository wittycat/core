package com.core.algorithm.kaoshi202205.八字符串;

/**
 * Created by chenxun.
 * Date: 2022/5/21 1:55 PM
 * Description:
 */
public class BM83字符串变形 {
    public static String trans(String s, int n) {
        if(s== null||s.equals("")){
            return s;
        }

        //split 丢失两头的 空格
        boolean start = s.startsWith(" ");
        boolean end = s.endsWith(" ");

        String[] split = s.split(" ");
        String[] res = new String[split.length];
        int j = 0;
        int i1 = split.length - 1;
        for (int i = i1; i > -1; i--) {
            res[j] = split[i];
            j++;
        }

        for (int i = 0; i < res.length ; i++) {
            char[] chars = res[i].toCharArray();

            for (int k = 0; k <chars.length ; k++) {
                chars[k]=change(chars[k]);
            }
            String r = String.valueOf(chars);
            res[i]=r;
        }

        String join = String.join(" ", res);
        if(end){
            join=" "+join;
        }
        if(start){
            join=join+" ";
        }
        return join;
    }

    private static char change(char s) {
        if(((int)s)>96){
            return (char)(((int)s)-32);
        }else {
            return (char)(((int)s)+32);
        }
    }

    public static void main(String[] args) {
        System.out.println(trans("This is a sample","This is a sample".length()));
    }
}