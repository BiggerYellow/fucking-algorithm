package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/1/11 9:35
 * @description
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
 *
 * 例如，数字字符串 "3322251" 的描述如下图：
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出："1"
 * 解释：这是一个基本样例。
 * 示例 2：
 *
 * 输入：n = 4
 * 输出："1211"
 * 解释：
 * countAndSay(1) = "1"
 * countAndSay(2) = 读 "1" = 一 个 1 = "11"
 * countAndSay(3) = 读 "11" = 二 个 1 = "21"
 * countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class countAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        String res = null;
        //从0遍历至n
        for (int i=0;i<n;i++){
            //循环递归获取前一项的描述
            res = getRes(res);
        }
        return res;
    }

    //获取前一项的描述
    public static String getRes(String res){
        //首位直接返回1
        if (res == null) return "1";
        StringBuilder sb = new StringBuilder();
        //字符串索引位置
        int index=0;
        //每个字符计数器
        int num =1;
        //上一个字符
        char temp = res.charAt(0);
        //遍历至res字符串结束
        while (index < res.length()){
            //索引加1
            index++;
            //当index = res.length()表明遍历到最后一位 直接拼接
            if (index == res.length()){
                sb.append(num).append(temp);
                break;
            }
            //如果上一个temp字符等于当前遍历的字符 则将num++ 否则拼接到sb中并将num置为1 temp置为当前索引的字符
            if (temp == res.charAt(index)){
                num++;
            }else {
                sb.append(num).append(temp);
                num=1;
                temp = res.charAt(index);
            }
        }
        return sb.toString();
    }
}
