package com.core.algorithm.kaoshi202205;

/**
 * https://www.nowcoder.com/exam/oj?page=1&tab=%E7%AE%97%E6%B3%95%E7%AF%87&topicId=295
 * 
 * 1.Arrays: 排序，查找
 *   java.util.Arrays#sort(int[], int, int)
 *   java.util.Arrays#sort(long[])
 *   java.util.Arrays#binarySearch(int[], int)
 *
 * 2.数据结构
 *   数组
 *
 *   单链表：
 *      解题思路
 *          虚头
 *          提前记录当前节点（指针）
 *   双链表：
 *      ArrayDeque
 *   栈
 *      Stack
 *      解题思路：
 *          2个栈，构建一个队列：一个放，一个取（没有了从另外一个放）
 *   队列
 *   堆
 *      PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //⼩顶堆，默认容量为11
 *      PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,new Comparator<Integer>(){
 *            @Override
 *            public int compare(Integer i1,Integer i2){
 *                      return i2-i1;
 *                  }
 *            });//⼤顶堆
 *   哈希
 *   二叉树
 *      类别
 *      满二叉树（最标准，节点最多）
 *          完全二叉树（倒数第一层左到右连续，倒数第二层左到右连续，）
 *          线索二叉树
 *      操作
 *          前序遍历：根左右
 *          中序遍历：左根右
 *          后续遍历：左右根
 *      解题思路：
 *          三种遍历，层级遍历（队列解决）->可以解决深度；"之"形状打印
 *          把整体二叉树看待成一个小二叉树，然后使用递归可以解决：
 *              合并2个二叉树;
 *              某个链路求和;
 *              二叉树的镜像;
 *
 * 3.算法
 *    查找：
 *     链式查找法：链表或者数组一个个比较查找
 *     二分查找法：
 *      一维数组，获取 最小（l），最大角标（r）去取中间角标m值，大于r=m-1，否则l=m+1
 *      二维数组，取左下角值，大y移动（y--），小了x移动（x++），找不到不存在
 *    排序：
 *     归并排序，【BM20 数组中的逆序对】
 *
 *
 *
 */

