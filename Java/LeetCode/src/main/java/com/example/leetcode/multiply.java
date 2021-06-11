package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/1/21 9:08
 * @description
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class multiply {
    public static void main(String[] args) {
//        String num1 = "123456789";
//        String num2 = "987654321";
        String num1 = "0";
        String num2 = "0";
        System.out.println(multiply1(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int i = getInt(num1) * getInt(num2);
        StringBuilder res = new StringBuilder();
        while (i!=0){
            res.append(i%10);
            i/=10;
        }
        res.reverse();
        return res.toString();
    }

    public static int getInt(String num){
        int size = num.length();
        int res=0;
        for (int i=0;i<size;i++){
            int suffix = size - i-1;
            if (suffix==0){
                res += (num.charAt(i) -'0');
            }else {
                res += (num.charAt(i) -'0') * (Math.pow(10, suffix));
            }
        }
        return res;
    }

    public static String multiply1(String num1, String num2) {
        //处理num1和num2 任意一个为0
        if (num1.equals("0") || num2.equals("0")) return "0";
        int size1 = num1.length();
        int size2 = num2.length();
        //定义初始化数组
        int[] res = new int[size1+size2];
        //从尾向前遍历计算 并赋值到数组中
        for (int i=size1-1;i>=0;i--){
            for (int j=size2-1;j>=0;j--){
                //计算乘积
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                //获取当前位置在数组中的位置
                int p1 = i+j, p2 = i+j+1;
                //求当前位置的最终和
                int sum = mul + res[p2];
                //填充到数组中
                res[p2] = sum%10;
                res[p1] += sum/10;
            }
        }

        // 结果前缀可能存的 0（未使用的位）
        int i = 0;
        while (i < res.length && res[i] == 0){
            i++;
        }
        // 将计算结果转化成字符串
        StringBuilder str = new StringBuilder();
        for (; i < res.length; i++)
            str.append(res[i]);

        return res.length == 0 ? "0" : str.toString();
    }

}
