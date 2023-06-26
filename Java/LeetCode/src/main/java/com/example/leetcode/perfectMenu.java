package com.example.leetcode;

/**
 * @author :huangchunchen
 * @date :Created in 2022/4/16 16:50
 * @description:
 * 2. 烹饪料理
 * 通过的用户数2173
 * 尝试过的用户数2535
 * 用户总通过次数2195
 * 用户总提交次数4827
 * 题目难度Easy
 * 欢迎各位勇者来到力扣城，城内设有烹饪锅供勇者制作料理，为自己恢复状态。
 *
 * 勇者背包内共有编号为 0 ~ 4 的五种食材，其中 meterials[j] 表示第 j 种食材的数量。通过这些食材可以制作若干料理，cookbooks[i][j] 表示制作第 i 种料理需要第 j 种食材的数量，
 * 而 attribute[i] = [x,y] 表示第 i 道料理的美味度 x 和饱腹感 y。
 *
 * 在饱腹感不小于 limit 的情况下，请返回勇者可获得的最大美味度。如果无法满足饱腹感要求，则返回 -1。
 *
 * 注意：
 *
 * 每种料理只能制作一次。
 * 示例 1：
 *
 * 输入：meterials = [3,2,4,1,2]
 * cookbooks = [[1,1,0,1,2],[2,1,4,0,0],[3,2,4,1,0]]
 * attribute = [[3,2],[2,4],[7,6]]
 * limit = 5
 *
 * 输出：7
 *
 * 解释：
 * 食材数量可以满足以下两种方案：
 * 方案一：制作料理 0 和料理 1，可获得饱腹感 2+4、美味度 3+2
 * 方案二：仅制作料理 2， 可饱腹感为 6、美味度为 7
 * 因此在满足饱腹感的要求下，可获得最高美味度 7
 *
 * 示例 2：
 *
 * 输入：meterials = [10,10,10,10,10]
 * cookbooks = [[1,1,1,1,1],[3,3,3,3,3],[10,10,10,10,10]]
 * attribute = [[5,5],[6,6],[10,10]]
 * limit = 1
 *
 * 输出：11
 *
 * 解释：通过制作料理 0 和 1，可满足饱腹感，并获得最高美味度 11
 *
 * 提示：
 *
 * meterials.length == 5
 * 1 <= cookbooks.length == attribute.length <= 8
 * cookbooks[i].length == 5
 * attribute[i].length == 2
 * 0 <= meterials[i], cookbooks[i][j], attribute[i][j] <= 20
 * 1 <= limit <= 100
 */
public class perfectMenu {

    public static void main(String[] args) {
//        int[] meterials = {3,2,4,1,2};
//        int[][] cookbooks = {{1,1,0,1,2},{2,1,4,0,0},{3,2,4,1,0}};
//        int[][] attribute = {{3,2},{2,4},{7,6}};
//        int limit = 5;


        int[] meterials = {10,10,10,10,10};
        int[][] cookbooks = {{1,1,1,1,1},{3,3,3,3,3},{10,10,10,10,10}};
        int[][] attribute = {{5,5},{6,6},{10,10}};
        int limit = 1;

        System.out.println(perfectMenu(meterials, cookbooks, attribute, limit));
    }

    public static int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {

        int[] cache = cookbooks[0];
        dfs(0, cache, attribute[0][1], attribute[0][0], materials, cookbooks, attribute, limit);
        return res;
    }

    public static int res = -1;

    public static void dfs(int index,int[] cache,int limitCache, int ress, int[] materials, int[][] cookbooks, int[][] attribute, int limit){
        if (!isOver(cache, materials) && limitCache >= limit){
            res = Math.max(res, ress);
        }
        for (int i=index+1;i<cookbooks.length;i++){
            for (int j=0;j<5;j++){
                cache[j]+=cookbooks[i][j];
            }
            limitCache += attribute[i][1];
            ress += attribute[i][0];

            dfs(i, cache, limitCache, ress, materials, cookbooks, attribute, limit);
            for (int j=0;j<5;j++){
                cache[j]-=cookbooks[i][j];
            }
            limitCache -= attribute[i][1];
            ress -= attribute[i][0];

        }
    }

    public static boolean isOver(int[] cache, int[] materials){
        for (int i=0;i<5;i++){
            if (cache[i] > materials[i]){
                return true;
            }
        }
        return false;
    }

}
