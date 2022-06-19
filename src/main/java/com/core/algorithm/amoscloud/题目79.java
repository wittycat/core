package com.core.algorithm.amoscloud;

import java.util.*;

/**
 * Created by chenxun.
 * Date: 2022/6/16 1:59 PM
 * Description:
 */
public class 题目79 {
    /**
     *
     *    某学校举行运动会,学生们按编号（1、2、3.....n)进行标识,
     *    现需要按照身高由低到高排列，
     *    对身高相同的人，按体重由轻到重排列，
     *    对于身高体重都相同的人，维持原有的编号顺序关系。
     *    请输出排列后的学生编号
     *    输入描述：
     *       两个序列，每个序列由N个正整数组成，(0<n<=100)。
     *       第一个序列中的数值代表身高，第二个序列中的数值代表体重，
     *    输出描述：
     *       排列结果，每个数据都是原始序列中的学生编号，编号从1开始，
     *    实例一：
     *       输入:
     *        4
     *        100 100 120 130
     *        40 30 60 50
     *       输出:
     *        2134
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Integer[] hights = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] weights = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            students.add(new Student(i, hights[i - 1], weights[i - 1]));
        }
        students.stream().sorted((o1, o2) -> {
            if (!o1.hight.equals(o2.hight)) {
                return o1.hight - o2.hight;
            } else {
                if (!o1.weight.equals(o2.weight)) {
                    return o1.weight - o2.weight;
                } else {
                    return o1.id - o2.id;
                }
            }
        }).map(Student::getId).forEach(id -> System.out.print(id + " "));
    }

    static class Student{
        private Integer id;
        private Integer hight;
        private Integer weight;

        public Student(Integer id, Integer hight, Integer weight) {
            this.id = id;
            this.hight = hight;
            this.weight = weight;
        }

        public Integer getId() {
            return id;
        }
    }
}