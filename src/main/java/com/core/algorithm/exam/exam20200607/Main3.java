package com.core.algorithm.exam.exam20200607;

import java.util.*;

/**
 * Created by chenxun.
 * Date: 2020/6/7 下午2:55
 * Description:
 */
public class Main3 {
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
            Set<String> bad = new HashSet(Arrays.asList(line2.split(",")));
            String[] split = line1.split(",");
            int oldSize = bad.size();
            boolean isfirst =true;
            while (bad.size() > oldSize||isfirst) {
                oldSize   = bad.size();
                for (int i = 0; i < split.length; i++) {
                    String[] pair = split[i].split("-");
                    if (bad.contains(pair[1])) {
                        bad.add(pair[0]);
                    }
                    isfirst = false;
                }
            }
            LinkedHashSet linkedList = new LinkedHashSet();
            for (int i = 0; i < split.length; i++) {
                String[] pair = split[i].split("-");
                linkedList.add(pair[0]);
                linkedList.add(pair[1]);
            }

            Iterator<String> iterator = bad.iterator();
            while (iterator.hasNext()) {
                linkedList.remove(iterator.next());
            }
            if(linkedList.isEmpty()){
                System.out.println(",");
            }else {
                System.out.println(linkedList.toString().replace("[","").replace("]",""));
            }

        }
    }
}