package swordOffer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @ClassName SwordOffer_28
 * @Description:
 * 第二十八题
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 * 字符串长度不超过9(可能有字符重复),字符只包括大小写字母。
 * @Author UESTC-ZKX
 * @Date 2020/2/11
 **/
public class SwordOffer_28 {

    MyUtils myUtils = new MyUtils();
    // 暴力法
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if (myUtils.isNull(str) || str.length() == 0 ){
            return res;
        }
        // 防止重复用TreeSet
        TreeSet<String> treeSet = new TreeSet<>();
        // 递归终止条件
        if (str.length() == 1){
            res.add(str);
            return res;
        }
        // 暂存第一个后的结果集
        ArrayList<String> temp = Permutation(str.substring(1));
        for(String s : temp) {
            for(int i = 0; i <= s.length(); i++) {
                StringBuilder stringBuilder = new StringBuilder(s);
                treeSet.add(stringBuilder.insert(i, str.charAt(0)).toString());
            }
        }
        res.addAll(treeSet);
        return res;
    }

    // TODO 回溯
}
