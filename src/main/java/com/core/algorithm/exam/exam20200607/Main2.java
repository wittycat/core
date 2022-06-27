package com.core.algorithm.exam.exam20200607;

import java.util.*;

/**
 * Created by chenxun.
 * Date: 2020/6/7 下午2:55
 * Description:
 */
public class Main2 {
    /**
     * a1-a2,a5-a6,a2-a3
     * a5,a2
     *
     * a6,a3
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line1 = scanner.nextLine();
            String line2 = scanner.nextLine();
            List<Set<String>> c = new ArrayList<>();
            LinkedList<Integer> linkedList = new LinkedList<>();
            String[] split = line1.split(",");
            for (int i = 0; i < split.length; i++) {
                String[] split1 = split[i].split("-");
                String a = split1[0];
                String b = split1[1];
                for (int j = 0; j < c.size() ; j++) {
                    Set c1 = c.get(j);
                    if(c1.contains(a)||c1.contains(b)){
                        c1.add(a);
                        c1.add(b);
                    }else {
                        Set<String> set = new HashSet<>();
                        set.add(a);
                        set.add(b);
                        c.add(set);
                    }
                }
            }




        }
    }
}