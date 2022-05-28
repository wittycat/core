package com.core.algorithm.nowcoder面试必刷TOP101.h八字符串;

/**
 * Created by chenxun.
 * Date: 2022/5/21 4:43 PM
 * Description:
 */
public class BM86大数加法 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    /**
     * 不适合int long 直接转化相加 溢出 逐步相加往前进1 现把长度补提
     * @param s
     * @param t
     * @return
     */

    public static String solve (String s, String t) {

        if(s==null||s.equals("")){
            return t;
        }
        if(t==null||t.equals("")){
            return s;
        }

        int abs = Math.abs(s.length() - t.length());
        String pre = "";
        for (int i = 0; i < abs; i++) {
            pre= pre+"0";
        }
        if(s.length()>t.length()){
            t = pre+t;
        }
        if(s.length()<t.length()){
            s = pre+s;
        }

        StringBuilder stringBuilder = new StringBuilder();
        char[] sstr = s.toCharArray();
        char[] tstr = t.toCharArray();
        int gao = 0;
        int length = t.length();
        for (int i = length-1; i > -1 ; i--) {
            int v = (sstr[i] - '0') + (tstr[i] - '0')+gao;
            gao = v / 10;
            int index = v % 10;
            stringBuilder.append(index);
        }
        if(gao>0){
            stringBuilder.append(gao);
        }
        return stringBuilder.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(solve("9","99999999999999999999999999999999999999999999999999999999999994"));
    }
}