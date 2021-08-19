package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/8/16 9:26
 * @description
 * Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n),
 * either of the following is true:
 *
 * perm[i] is divisible by i.
 * i is divisible by perm[i].
 * Given an integer n, return the number of the beautiful arrangements that you can construct.
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation:
 * The first beautiful arrangement is [1,2]:
 *     - perm[1] = 1 is divisible by i = 1
 *     - perm[2] = 2 is divisible by i = 2
 * The second beautiful arrangement is [2,1]:
 *     - perm[1] = 2 is divisible by i = 1
 *     - i = 2 is divisible by perm[2] = 1
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *  
 *
 * Constraints:
 *
 * 1 <= n <= 15
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/beautiful-arrangement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class countArrangement {
    public static void main(String[] args) {
        System.out.println(countArrangement1(4));
    }


    public static int count=0;

    public static int countArrangement(int n) {
        List<Integer> track = new ArrayList<>();
        dfs(n, track);
        return count;
    }

    public static void dfs(int n, List<Integer> track){
        if (track.size() == n){
            count++;
            return;
        }
        for (int i=1;i<=n;i++){
            if (track.contains(i)){
                continue;
            }
            track.add(i);
            if (i%track.size() == 0 || track.size()%i==0){
                dfs(n, track);
            }
            track.remove(track.size()-1);
        }
    }

    public static boolean[] visited;

    public static int countArrangement1(int n){
        visited = new boolean[n+1];
        dfs(1, n);
        return count;
    }

    public static void dfs(int i, int n){
        if (i == n+1){
            count++;
            return;
        }
        for (int num=1;num<=n;num++){
            if (!visited[num] && (num%i == 0 || i%num==0)){
                visited[num] = true;
                dfs(i+1, n);
                visited[num] = false;
            }
        }
    }
}
