package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangchunchen
 * @date 2021/6/10 11:16
 * @description
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 *
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 *
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 *
 *  
 * 示例 1：
 *
 * 输入：k = 1, n = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，肯定能得出 f = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，肯定能得出 f = 1 。
 * 如果它没碎，那么肯定能得出 f = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。
 * 示例 2：
 *
 * 输入：k = 2, n = 6
 * 输出：3
 * 示例 3：
 *
 * 输入：k = 3, n = 14
 * 输出：4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class superEggDrop {
    public static void main(String[] args) {
        System.out.println(superEggDrop4(3,14));
    }

    //递归 超时
    //时间复杂度:O(k*n^2)
    public static int superEggDrop(int k, int n) {
        return dp(k,n);
    }

    public static int dp(int k, int n){
        if (k==1) return n;
        if (n==0) return 0;
        int res=Integer.MAX_VALUE;
        for (int i=1;i<=n;i++){
            res = Math.min(res, Math.max(dp(k-1, i-1), dp(k,n-i))+1);
        }
        return res;
    }

    //备忘录
    public static int superEggDrop1(int k, int n){
        return dp1(k,n);
    }
    public static Map<Integer, Integer> map = new HashMap<>();
    public static int dp1(int k,int n){
        if (k==1) return n;
        if (n==0)return 0;
        int res=Integer.MAX_VALUE;
        Integer key=k*100+n;
        if (map.containsKey(key)){
            return map.get(key);
        }
        for (int i=1;i<=n;i++){
            res = Math.min(res, Math.max(dp(k-1, i-1), dp(k, n-i))+1);
            map.put(key, res);
        }
        return res;
    }


    //备忘录+二分搜索
    public static int superEggDrop2(int k, int n){
        return dp2(k,n);
    }
    public static int dp2(int k,int n){
        if (k==1) return n;
        if (n==0)return 0;
        int res=Integer.MAX_VALUE;
        Integer key=k*100+n;
        if (map.containsKey(key)){
            return map.get(key);
        }
        int lo=1,hi=n;
        while (lo+1<hi){
            int mid = lo + (hi-lo)/2;
            int broken = dp2(k-1, mid-1);
            int noBroken = dp2(k, n-mid);
            if (broken>noBroken){
                hi=mid;
            }else if (broken<noBroken){
                lo=mid;
            }
            res = 1+Math.min(Math.max(dp(k-1, hi-1), dp(k, n-hi)), Math.max(dp(k-1,lo-1), dp(k, n-lo)));
            map.put(key, res);
        }

        return res;
    }

    public static int superEggDrop3(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        int m=0;
        while (dp[k][m]<n){
            m++;
            for (int j=1;j<=k;j++){
                dp[j][m] = dp[j][m-1] + dp[j-1][m-1]+1;
            }
        }
        return m;
    }

    static Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public static int superEggDrop4(int k, int n) {
        return dp4(k, n);
    }

    public static int dp4(int k, int n) {
        if (!memo.containsKey(n * 100 + k)) {
            int ans;
            if (n == 0) {
                ans = 0;
            } else if (k == 1) {
                ans = n;
            } else {
                int lo = 1, hi = n;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = dp4(k - 1, x - 1);
                    int t2 = dp4(k, n - x);

                    if (t1 < t2) {
                        lo = x;
                    } else if (t1 > t2) {
                        hi = x;
                    } else {
                        lo = hi = x;
                    }
                }

                ans = 1 + Math.min(Math.max(dp(k - 1, lo - 1), dp(k, n - lo)), Math.max(dp(k - 1, hi - 1), dp(k, n - hi)));
            }

            memo.put(n * 100 + k, ans);
        }

        return memo.get(n * 100 + k);
    }

    }
