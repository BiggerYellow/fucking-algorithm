package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Track;

/**
 * @author huangchunchen
 * @date 2021/9/5 10:31
 * @description
 * 5863. 统计特殊四元组 显示英文描述
 * 通过的用户数0
 * 尝试过的用户数0
 * 用户总通过次数0
 * 用户总提交次数0
 * 题目难度Easy
 * 给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
 *
 * nums[a] + nums[b] + nums[c] == nums[d] ，且
 * a < b < c < d
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,6]
 * 输出：1
 * 解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
 * 示例 2：
 *
 * 输入：nums = [3,3,6,4,5]
 * 输出：0
 * 解释：[3,3,6,4,5] 中不存在满足要求的四元组。
 * 示例 3：
 *
 * 输入：nums = [1,1,1,3,5]
 * 输出：4
 * 解释：满足要求的 4 个四元组如下：
 * - (0, 1, 2, 3): 1 + 1 + 1 == 3
 * - (0, 1, 3, 4): 1 + 1 + 3 == 5
 * - (0, 2, 3, 4): 1 + 1 + 3 == 5
 * - (1, 2, 3, 4): 1 + 1 + 3 == 5
 *
 *
 * 提示：
 *
 * 4 <= nums.length <= 50
 * 1 <= nums[i] <= 100
 */
public class countQuadruplets {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,5};
        System.out.println(countQuadruplets(nums));
    }

    public static int res=0;

    public static int countQuadruplets(int[] nums) {
        List<Integer> track = new ArrayList<>();
        dfs(nums, track);
        return res;
    }

    public static void dfs(int[] nums, List<Integer> track){
        if (track.size() == 4 && (nums[track.get(0)]+nums[track.get(1)]+nums[track.get(2)]) == track.get(3) &&
                (track.get(0)<track.get(1)&&  track.get(1)<track.get(2) && track.get(2)<track.get(3))){
            res++;
            return;
        }

        for (int i=0;i<nums.length;i++){
            if (track.size()==4){
                if ((nums[track.get(0)]+nums[track.get(1)]+nums[track.get(2)]) > track.get(3)){
                    continue;
                }else {
                    break;
                }
            }
            track.add(i);
            dfs(nums, track);
            track.remove(track.size()-1);
        }
    }
}
