package swordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SwordOffer_04
 * @Description:
 * 第4题
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 输出：We%20Are%20Happy。
 * @Author UESTC-ZKX
 * @Date 2020/1/21
 **/
public class SwordOffer_04 {
    MyUtils myUtils = new MyUtils();
    // 调用replace方法
    public String replaceSpace(StringBuffer str) {
        // 判空
        if(myUtils.isNull(str)){
            return "输入为空！";
        }
        String s = str.toString();
        return s.replace(" ","%20");
    }
    // 手写循环
    public String replaceSpace_1(StringBuffer str) {
        // 判空
        if(myUtils.isNull(str)){
            return "输入为空！";
        }
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' ') {
                res.append("%20");
            }
            else {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }
}
