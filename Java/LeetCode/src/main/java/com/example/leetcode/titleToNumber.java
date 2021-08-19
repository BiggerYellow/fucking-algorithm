package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/7/30 9:46
 * @description
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class titleToNumber {
    public static void main(String[] args) {
        String columeTitle = "AB";
        System.out.println(titleToNumber(columeTitle));
    }

    public static int titleToNumber(String columnTitle) {
        int res=0;
        for (char c:columnTitle.toCharArray()){
            int k = c - 'A' + 1;
            res = res*26+k;
        }
        return res;
    }
}
