package com.example.leetcode;

import java.util.Stack;

/**
 * @author huangchunchen
 * @date 2021/5/26 9:09
 * @description
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 *
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 *
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *
 * a(bc(mn)p)q
 * a(bcnmp)q
 * apmncbq
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class reverseParentheses {
    public static void main(String[] args) {
//        System.out.println(reverseParentheses("((e(f()(((()vbl))s)i(hbo)(j((emr(g((dyvz(j(k))qn(r(s))(by()lg)(z)(v))po(ri))uq)(())(i)((((joovdi(r(hov)tk)ycpv))(uu)n)((pc(kmhzko(h)j())x)idpe(tf(a()j)lcszq)el)e)(q)s)))h((()hq))ty)z((r)(etuimhqk(vc)o(x(eavtr)c())gr(iaeh))(uijw)ribmj((nmxndbljlphzisqms)q)hp(()(((k)y(qfjwg)t(v)rye(mm)jonu()gwv))(()dtc(nf)a)q)(l(g)ls)(elxperab)ugnutxcd)ucbet)joc(e(ka)))ayudqadlo()(s(rkyp)u)uoukgnkbxvgqpm()u()ofcoobafiyurfx()bwcnlgnjieh((up)lfo(nfzid(wpcttauya((d)(lt(s)fa(o))it(gn)(imb(rp(b)v(w((kt())qcia(lsu(nx)biucqc)g(rjvzm)))(af(p)(km)c(ozd)i(a(ufpmqyty)gd(unoo()ncwc)b(buj)s))(z))yh)goq(u)((kn)kpa)kfe(r(aurgx)ke)xpa(lofufr((r())d)(wlw(ew)))))(k)()(lwq)wksx))pavt(w)n(jn)gewybef(t)djbyk((b))lkqiyxo(on)yckdkzfmradisc()(o)qdl((asms(c((t)zwcc)g)(pc)()e((((rlm(jegb)zcu((bw(mbps(g)n)fgkjkb(fp(vm(tzsp)(t((t)d()c(x(ktviam(e((r)xfktm)vc(w)hi(ylenyelvde(lu((xce)ofbiv)je)t((oqp)jng)vr)o)ctdkzogm((km)nk))gv)xjueo(qmclm()r)ttg))c)wv())qlrs)(sl(fo(e))nxsjmgxt)nyg(dn()((((ri(b(as()qyg)amcy)vk()()((ny(()(x(gu(q)lxx(m()))))))))))))))))))"));
        System.out.println(reverseParentheses("a(bc(mn)p)q"));
    }

    //借用栈的先进后出来处理
    //当遇到右括号时 将栈中的元素弹出 直到遇到左括号 再将元素继续入栈 直到没有括号 即遍历到最后
    //最后将栈中的所有元素逆序输出
    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()){
            if (c==')'){
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
                for (char ch:sb.toString().toCharArray()){
                    stack.push(ch);
                }
            }else {
                stack.push(c);
            }
        }
        StringBuilder res =new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

}
