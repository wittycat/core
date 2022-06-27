package com.core.algorithm.exam.exam20220621;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by chenxun.
 * Date: 2022/6/21 10:11 AM
 * Description:
 */
public class Test01 {
    /**
     * M G T
     * 3
     * 1G
     * 2G
     * 1024M
     *
     * 3
     * 2G4M
     * 3M2G
     * 1T
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer i = Integer.valueOf(scanner.nextLine());
        List<Disk> list = new ArrayList();
        while (i > 0) {
            list.add(new Disk(i, scanner.nextLine()));
            i--;
        }
        List<Disk> collect = list.stream().sorted(new Comparator<Disk>() {
            @Override
            public int compare(Disk o1, Disk o2) {
                if (o1.value != o2.value) {
                    return o1.value - o2.value;
                } else {
                    return o2.priority - o1.priority;
                }
            }
        }).collect(Collectors.toList());
        collect.forEach(disk -> System.out.println(disk.old));
    }

    static class Disk {
        int priority;
        String old;
        int value;
        public Disk(int priority, String old) {
            this.priority = priority;
            this.old = old;
            setValueBy(this.old);
        }
        public void setValueBy(String old) {
            int x1 = 0;
            int x2 = 0;
            int y = 1;
            int sum = 0;//m
            for (int i = 0; x1 < old.length() && y < old.length() && i < old.length(); ) {
                while (old.charAt(y) != 'M' && old.charAt(y) != 'G' && old.charAt(y) != 'T') {
                    y++;
                }
                x2 = y;

                int m = Integer.parseInt(old.substring(x1, x2));
                char v = old.charAt(y);
                if (v == 'M') {
                    sum += m;
                }
                if (v == 'G') {
                    sum += m * 1024;
                }
                if (v == 'T') {
                    sum += m * 1024 * 1024;
                }
                x1 = y + 1;
                y++;
            }
            this.value = sum;
        }
    }
}