package com.core.algorithm.amoscloud2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by chenxun.
 * Date: 2022/6/16 11:20 AM
 * Description:
 */
public class 题目85 {
    /**
     *
     *     有一个特殊的五键键盘
     *     上面有A、Ctrl-C、Ctrl-X、Ctrl-V、Ctrl-A
     *     A键在屏幕上输出一个字母A
     *     Ctrl-C将当前所选的字母复制到剪贴板
     *     Ctrl-X将当前选择的字母复制到剪贴板并清空所选择的字母
     *     Ctrl-V将当前剪贴板的字母输出到屏幕
     *     Ctrl-A选择当前屏幕中所有字母
     *     注意：
     *       1. 剪贴板初始为空
     *       2. 新的内容复制到剪贴板会覆盖原有内容
     *       3. 当屏幕中没有字母时,Ctrl-A无效
     *       4. 当没有选择字母时Ctrl-C、Ctrl-X无效
     *       5. 当有字母被选择时A和Ctrl-V这两个输出功能的键,
     *          会先清空所选的字母再进行输出
     *
     *     给定一系列键盘输入,
     *     输出最终屏幕上字母的数量
     *
     *     输入描述:
     *        输入为一行
     *        为简化解析用数字12345分别代替A、Ctrl-C、Ctrl-X、Ctrl-V、Ctrl-A的输入
     *        数字用空格分割
     *
     *     输出描述:
     *         输出一个数字为屏幕上字母的总数量
     *
     *     示例一:
     *         输入:
     *           1 1 1
     *         输出:
     *           3
     *
     *    示例二:
     *         输入:
     *           1 1 5 1 5 2 4 4
     *         输出:
     *           2
     *
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> commands = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<String> black = new ArrayList<>();
        List<String> select = new ArrayList<>();
        List<String> clipboard = new ArrayList<>();
        for (int i = 0; i < commands.size(); i++) {
            switch (commands.get(i)) {
                case 1: {
                    if (!select.isEmpty()) {
                        black.removeAll(select);
                        select.clear();
                    }
                    black.add("A");
                    break;
                }
                case 2: {
                    clipboard.clear();
                    clipboard.addAll(select);
                    break;
                }
                case 3: {
                    clipboard.clear();
                    clipboard.addAll(select);
                    black.clear();
                    select.clear();
                    break;
                }
                case 4: {
                    if (!select.isEmpty()) {
                        black.removeAll(select);
                        select.clear();
                    }
                    black.addAll(clipboard);
                    break;
                }
                case 5: {
                    select.clear();
                    select.addAll(black);
                    break;
                }
            }
        }
        System.out.println(black.size());
    }
}