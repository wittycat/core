package com.core.algorithm.nowcoder华为机试;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by chenxun.
 * Date: 2020/6/2 下午10:38
 * Description:
 * https://www.nowcoder.com/practice/8e400fd9905747e4acc2aeed7240978b?tpId=37&&tqId=21291&rp=1&ru=/activity/oj&qru=/ta/huawei/question-ranking
 *
 */
public class Main68 {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            int count = Integer.parseInt(line);
            int order = Integer.parseInt(reader.readLine());

            Map<String, Integer> pair = new LinkedHashMap<>(count);
            for (int i = 0; i < count; i++) {
                String[] split = reader.readLine().split("\\s");
                pair.put(split[0] + "_" + i, Integer.parseInt(split[1]));
            }

            List list = new ArrayList(count);
            List<Integer> sortScore = new ArrayList(new HashSet(pair.values()));
            Collections.sort(sortScore);
            sortScore.stream().forEach(score -> {
                Set<String> names = pair.keySet();
                names.stream().forEach(name -> {
                    if (pair.get(name).equals(score)) {
                        list.add(name.split("_")[0] + " " + score);
                    }
                });
            });
            if (order == 0) {
                Collections.reverse(list);
            }
            list.stream().forEach(lines -> {
                System.out.println(lines);
            });

        }
    }
}