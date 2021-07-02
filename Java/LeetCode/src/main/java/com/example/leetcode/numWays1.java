package com.example.leetcode;

import java.util.*;

/**
 * @author huangchunchen
 * @date 2021/7/1 9:26
 * @description
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 *
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 *
 * 示例 1：
 *
 * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 *
 * 输出：3
 *
 * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 *
 * 示例 2：
 *
 * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
 *
 * 输出：0
 *
 * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
 *
 * 限制：
 *
 * 2 <= n <= 10
 * 1 <= k <= 5
 * 1 <= relation.length <= 90, 且 relation[i].length == 2
 * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chuan-di-xin-xi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class numWays1 {

    public static void main(String[] args) {
        int[][] relation = {{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        System.out.println(numWays2(5, relation, 3));
    }

    public static int res=0;
    public static Map<Integer, Set<Integer>> neighborList = new HashMap<>();

    //使用邻接表 加上 dfs
    public static int numWays(int n, int[][] relation, int k) {
        for (int i=0;i<relation.length;i++){
            int[] nums = relation[i];
            Set<Integer> neig = neighborList.getOrDefault(nums[0], new HashSet<>());
            neig.add(nums[1]);
            neighborList.put(nums[0], neig);

        }
        int target = n-1;
        //从0开始且当前轨迹数也为0
        dfs(0, 0, target, k);
        return res;
    }

    public static void dfs(int start, int track, int target, int k){
        //先判断轨迹在判断值是否相等,因为走过k个轨迹最终结果不一定等于target
        if (track == k){
            if (start == target){
                res++;
            }
            return;
        }
        //获取当前节点的下一个节点集合
        Set<Integer> integers = neighborList.get(start);
        if (integers == null) return;
        //继续遍历下个节点
        for (Integer num:integers){
            dfs(num, track+1, target, k);
        }
    }

    //使用bfs  遍历至k层 在统计队列中值为n-1的次数
    public static int numWays1(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> neigMap = new HashMap<>();
        for (int[] nums:relation){
            Set<Integer> neig = neigMap.getOrDefault(nums[0], new HashSet<>());
            neig.add(nums[1]);
            neigMap.put(nums[0], neig);
        }

        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(0);
        while (!deque.isEmpty() && k-->0){
            int size = deque.size();
            for (int i=0;i<size;i++){
                Integer temp = deque.pollFirst();
                Set<Integer> integers = neigMap.get(temp);
                if (integers == null) continue;
                for (Integer num:integers){
                    deque.addLast(num);
                }
            }
        }

        int res=0;
        while (!deque.isEmpty()){
            if (deque.pollLast() == n-1){
                res++;
            }
        }
        return res;
    }


    //动态规划
    //动态方程: dp[i][j] 代表 经过i步传到第j个人的手里的方案数
    //转移方程:  双层遍历,最外层遍历步数k,内层遍历所有的可能性
    //          relation[i][0] = p  relation[i][1] = j
    //          dp[i][j] = dp[i][j] + dp[i-1][p]
    //初始化: dp[0][0]=1
    //结果: dp[k][n-1]
    public static int numWays2(int n, int[][] relation, int k) {
        int[][] dp = new int[k+1][n];
        dp[0][0]=1;
        for (int i=1;i<=k;i++){
            for (int[] rela:relation){
                dp[i][rela[1]] += dp[i-1][rela[0]];
            }
        }
        return dp[k][n-1];
    }


    }
