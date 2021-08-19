package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/7/23 9:14
 * @description
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
 *
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 *
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * 输出：true
 * 解释：2 到 5 的每个整数都被覆盖了：
 * - 2 被第一个区间覆盖。
 * - 3 和 4 被第二个区间覆盖。
 * - 5 被第三个区间覆盖。
 * 示例 2：
 *
 * 输入：ranges = [[1,10],[10,20]], left = 21, right = 21
 * 输出：false
 * 解释：21 没有被任何一个区间覆盖。
 *  
 *
 * 提示：
 *
 * 1 <= ranges.length <= 50
 * 1 <= starti <= endi <= 50
 * 1 <= left <= right <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class isCovered {
    public static void main(String[] args) {
//        int[][] range = {{1,2},{3,4},{5,6}};
//        int[][] range = {{1,10},{10,20}};
        int[][] range = {{1,50}};
        System.out.println(isCovered1(range, 1, 50));
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        int[] arr = new int[51];
        for (int i=0;i<ranges.length;i++){
            for (int j=ranges[i][0];j<=ranges[i][1];j++){
                arr[j]++;
            }
        }
        for (int i=left;i<=right;i++){
            if (arr[i] == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isCovered1(int[][] ranges, int left, int right) {
        int[] arr = new int[52];
        for (int i=0;i<ranges.length;i++){
            arr[ranges[i][0]]++;
            arr[ranges[i][1]+1]--;
        }
        int[] sum = new int[52];
        sum[0]=arr[0];
        for (int i=1;i<=51;i++){
            sum[i] = arr[i]+sum[i-1];
        }

        for (int i=left;i<=right;i++){
            if (sum[i] <= 0){
                return false;
            }
        }
        return true;
    }
    }
