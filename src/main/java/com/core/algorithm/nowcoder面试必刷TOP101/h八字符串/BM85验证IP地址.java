package com.core.algorithm.nowcoder面试必刷TOP101.h八字符串;

/**
 * Created by chenxun.
 * Date: 2022/5/21 5:33 PM
 * Description:
 */
public class BM85验证IP地址 {
    /**
     * 验证IP地址
     * @param IP string字符串 一个IP地址字符串
     * @return string字符串
     */
    /**
     * ipv4 : 0到 255
     * ipv6 : 4位 16进制
     * @param IP
     * @return
     */
    public static String solve (String IP) {
        String Neither = "Neither";
        if(IP==null||IP.length()==0){
            return Neither;
        }

        if(IP.contains(".")){
            String[] split = IP.split("\\.");
            if(split.length!=4){
                return Neither;
            }
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                char[] chars = s.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    int v = (int)chars[j];
                    if(v<48||v>57){
                        return Neither;
                    }
                }
                int num = Integer.parseInt(s);
                if ((s.startsWith("0") && s.length() > 1) || num > 255 || num< 0) {
                    return Neither;
                }
            }
            return "IPv4";
        }

        if(IP.contains(":")){
            if(IP.startsWith(":")||IP.endsWith(":")){
                return Neither;
            }
            String[] split = IP.split("\\:");
            if(split.length!=8){
                return Neither;
            }
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                if((s.length()==0|| s.length()>4)){
                    return Neither;
                }
                char[] chars = s.toCharArray();
                for (int j = 0; j < s.length() ; j++) {
                    int value = (int)chars[j];
                    boolean isok = isok(value);
                    if(!isok){
                        return Neither;
                    }
                }
            }
            return "IPv6";
        }
        return Neither;
    }

    private static  boolean isok(int value) {
        if(value>47&&value<57){
            return true;
        }
        if(value>96&&value<103){
            return true;
        }
        if(value>64&&value<71){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solve("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}