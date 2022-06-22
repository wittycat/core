package com.core.algorithm.nowcoder.面试必刷TOP101.i九双指针;

/**
 * Created by chenxun.
 * Date: 2022/5/21 6:21 PM
 * Description:
 */
public class BM87合并两个有序的数组 {
    public static void merge(int A[], int m, int B[], int n) {
        if (m == 0) {
            for (int x = 0; x<n; x++) {
                A[x] = B[x];
            }
            return;
        }
        if (n == 0) {
            return;
        }

        int[] all = new int[m + n];

        int a = 0;
        int b = 0;
        int allInedex = 0;

        while (a < m || b < n) {
            if (a < m && b >= n) {
                all[allInedex] = A[a];
                allInedex++;
                a++;
                continue;
            }
            if (a >= m && b < n) {
                all[allInedex] = B[b];
                allInedex++;
                b++;
                continue;
            }

            int avalue = A[a];
            int bvalue = B[b];
            if (avalue < bvalue) {
                all[allInedex] = avalue;
                allInedex++;
                a++;
            } else if (avalue == bvalue) {
                all[allInedex] = avalue;
                all[allInedex + 1] = bvalue;
                allInedex = allInedex + 2;
                a++;
                b++;
            } else {
                all[allInedex] = bvalue;
                allInedex++;
                b++;
            }
        }
        for (int x = 0; x<all.length; x++) {
            A[x] = all[x];
        }
    }

    public static void main(String[] args) {
        int A[]= new int[2];
        A[0]=2;
        int m=1;

        int B[]={1};
        int n=B.length;
        merge(A,m,B,n);
    }
}