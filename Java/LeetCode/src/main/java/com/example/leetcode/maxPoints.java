package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangchunchen
 * @date 2021/6/24 0:26
 * @description
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 * 示例 2：
 *
 *
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-points-on-a-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxPoints {
    public static void main(String[] args) {
        //                         1          1    1      1
        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(maxPoints(points));
    }

    //y-y0=k(x-x0)
    //k=(y1-y2)/(x1-x2)
    public static int maxPoints(int[][] points) {
        Map<Double, Integer> map = new HashMap<>();
        for (int i=0;i<points.length;i++){
            for (int j=0;j<points.length;j++){
                double k =0;
                if (points[i][0]-points[j][0] != 0){
                    k = (points[i][1]-points[j][1])/(points[i][0]-points[j][0]);
                }
                if (map.containsKey(k)){
                    map.put(k, map.get(k).intValue()+1);
                }else {
                    map.put(k,1);
                }
            }
        }
        int res=0;
        for (Integer temp:map.values()){
            res = Math.max(temp, res);
        }
        return res;
    }
}
