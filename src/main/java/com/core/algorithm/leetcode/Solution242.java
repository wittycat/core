package com.core.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by chenxun.
 * Date: 2020/6/6 下午7:00
 * Description:
 *
 */
public  class Solution242 {

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        List<Character> list1 = new ArrayList();
        List<Character> list2 = new ArrayList();
        for (int i = 0; i < chars1.length; i++) {
            list1.add(new Character(chars1[i]));
            list2.add(new Character(chars2[i]));
        }
        list1.sort(Comparator.naturalOrder());
        list2.sort(Comparator.naturalOrder());
        HashSet<List<Character>> objects = new HashSet<>();
        return list1.equals(list2) ? true : false;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
}