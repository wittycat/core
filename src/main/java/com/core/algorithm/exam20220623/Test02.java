package com.core.algorithm.exam20220623;

import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2022/6/23 12:02 PM
 * Description:
 */
public class Test02 {
    /**
     * https://blog.csdn.net/weixin_41010318/article/details/119961919?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-119961919-blog-124238360.pc_relevant_blogantidownloadv1&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-119961919-blog-124238360.pc_relevant_blogantidownloadv1&utm_relevant_index=2
     *         TLV编码是按 Tag Length  Value格式进行编码的
     *         一段码流中的信元用tag标识，tag在码流中唯一不重复
     *         length表示信元value的长度  value表示信元的值
     *         码流以某信元的tag开头 ，tag固定占一个字节
     *         length固定占两个字节，字节序为小端序
     *         现给定tlv格式编码的码流以及需要解码的信元tag
     *         请输出该信元的value
     *
     *         输入码流的16机制字符中，不包括小写字母
     *         且要求输出的16进制字符串中也不要包含字符字母
     *         码流字符串的最大长度不超过50000个字节
     *
     *         输入描述
     *            第一行为第一个字符串 ，表示待解码信元的tag
     *            输入第二行为一个字符串， 表示待解码的16进制码流
     *           字节之间用空格分割
     *         输出描述
     *            输出一个字符串，表示待解码信元以16进制表示的value
     *
     *            例子：
     *            输入：
     *             31
     *             32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
     *
     *            输出
     *             32 33
     *
     *            说明：
     *            需要解析的信源的tag是31
     *            从码流的起始处开始匹配，tag为32的信元长度为1(01 00,小端序表示为1)
     *            第二个信元的tag为90 其长度为2
     *            第三个信元的tag为30 其长度为3
     *            第四个信元的tag为31 其长度为2(02 00)
     *            所以返回长度后面的两个字节即可 为 32 33
     *
     * Tag Length  Value
     * 31
     * 32 01 00 AE
     * 90 02 00 01 02
     * 30 03 00 AB 32 31
     * 31 02 00 32 33
     * 33 01 00 CC
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] djm = scanner.nextLine().split(" ");
        for (int i = 0; i < djm.length; ) {
            String num = djm[i + 2] + djm[i + 1];
            int length = Integer.parseInt(num, 16);
            if (djm[i].equals(s)) {
                String a = "";
                for (int j = i + 3; j < length + i + 3; j++) {
                    a = a + djm[j] + " ";
                }
                System.out.println(a);
                break;
            } else {
                i = i + length + 3;
            }
        }
    }
}