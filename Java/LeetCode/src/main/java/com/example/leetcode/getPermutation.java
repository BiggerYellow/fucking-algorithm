package com.example.leetcode;

import java.util.PriorityQueue;

/**
 * @author huangchunchen
 * @date 2021/9/14 11:15
 * @description
 * 60. Permutation Sequence
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 * Example 3:
 *
 * Input: n = 3, k = 1
 * Output: "123"
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 * 1 <= k <= n!
 */
public class getPermutation {
    public static void main(String[] args) {
        System.out.println(getPermutation(4,9));
    }

    public static boolean[] cache;
    public static int[] factorial;
    public static int N;
    public static int K;

    public static String getPermutation(int n, int k) {
        N = n;
        K = k;
        factorial = new int[n+1];
        factorial[0]=1;
        for (int i=1;i<=n;i++){
            factorial[i] = factorial[i-1]*i;
        }

        cache = new boolean[n+1];

        StringBuilder track = new StringBuilder();
        dfs(0, track);
        return track.toString();
    }

    public static void dfs(int index, StringBuilder track){
        if (index == N){
            return;
        }
        int cnt= factorial[N-1-index];
        for (int i=1;i<=N;i++){
            if (cache[i]){
                continue;
            }
            if (cnt<K){
                K-=cnt;
                continue;
            }

            track.append(i);
            cache[i]=true;
            dfs(index+1, track);
            return;
        }
    }

}
