package swordOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SwordOffer_35
 * @Description: 第三十五题
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * @Author UESTC-ZKX
 * @Date 2020/2/14
 **/
public class SwordOffer_35 {

    public int FirstNotRepeatingChar(String str) {
        int res = -1;
        if (str.equals("")) {
            return -1;
        }
        Map<Character, IndexAndNum> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.get(chars[i]).num++;
            } else {
                map.put(chars[i], new IndexAndNum(i, 1));
            }
        }
        for (IndexAndNum indexAndNum : map.values()) {
            if (indexAndNum.num == 1) {
                if (res == -1 || indexAndNum.firstIndex < res) {
                    res = indexAndNum.firstIndex;
                }
            }
        }
        return res;
    }

    /**
     * 存储第一次出现的位置和数量
     */
    class IndexAndNum {
        int firstIndex = 0, num = 0;

        IndexAndNum(int firstIndex, int num) {
            this.firstIndex = firstIndex;
            this.num = num;
        }
    }

    // 位图法
    public int FirstNotRepeatingChar_1(String str) {
        if (str == null || str.length() == 0) return -1;
        int[] count = new int[256];
        //用一个类似hash的东西来存储字符出现的次数，很方便
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;
        //遍历一遍数组并访问hash记录
        for (int i = 0; i < str.length(); i++)
            if (count[str.charAt(i)] == 1)
                return i;
        return -1;
    }

}
