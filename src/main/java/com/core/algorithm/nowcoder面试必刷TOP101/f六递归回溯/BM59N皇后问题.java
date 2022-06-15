package com.core.algorithm.nowcoder面试必刷TOP101.f六递归回溯;

/**
 * Created by chenxun.
 * Date: 2022/6/15 11:14 AM
 * Description:
 */
public class BM59N皇后问题 {

    private static int all = 0;

    public static int Nqueen(int n) {
        int[][] arr = new int[n][n];
        dfs(arr, 0);
        return all;
    }

    /**
     * @param arr
     * @param i   第几行
     */
    private static void dfs(int[][] arr, int i) {
        int n = arr.length;
        if (i == n) {
//            AtomicInteger sum = new AtomicInteger();
//            Arrays.stream(arr).forEach(item -> {
//                for (int j = 0; j <item.length ; j++) {
//                    if(item[j]==1){
//                        sum.getAndIncrement();
//                    }
//                }
//                System.out.println(Arrays.toString(item));
//            });
//            System.out.println("===================================="+sum.get());
            all++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (arr[i][j] == 0 && verify(i, j, arr)) {
                arr[i][j] = 1;
                dfs(arr, i + 1);
                arr[i][j] = 0;
            }
        }
    }

    private static boolean verify(int i, int j, int[][] arr) {
        int n = arr.length;
        //行
        for (int row = 0; row < n; row++) {
            if (arr[i][row] == 1) {
                return false;
            }
        }
        //列
        for (int col = 0; col < n; col++) {
            if (arr[col][j] == 1) {
                return false;
            }
        }
        //左上
        for (int i1 = i, j1 = j; i1 >= 0 && j1 >= 0; ) {
            if (arr[i1][j1] == 1) {
                return false;
            }
            i1--;
            j1--;
        }
        //左下
        for (int i1 = i, j1 = j; i1 < n && j1 < n; ) {
            if (arr[i1][j1] == 1) {
                return false;
            }
            i1++;
            j1++;
        }


        //右上
        for (int i1 = i, j1 = j; i1 >=0 && j1 < n; ) {
            if (arr[i1][j1] == 1) {
                return false;
            }
            i1--;
            j1++;
        }
        //右下
        for (int i1 = i, j1 = j; i1 < n && j1 >= 0; ) {
            if (arr[i1][j1] == 1) {
                return false;
            }
            i1++;
            j1--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Nqueen(8));
    }

}