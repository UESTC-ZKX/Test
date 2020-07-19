package swordOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName SwordOffer_44
 * @Description: 第四十四题
 * LL今天心情特别好,因为他去买了一副扑克牌,
 * 发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
 * 如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,
 * “Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),
 * “So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。
 * 为了方便起见,你可以认为大小王是0。
 * @Author UESTC-ZKX
 * @Date 2020/2/18
 **/
public class SwordOffer_44 {

    public boolean isContinuous(int[] numbers) {
        if (numbers.length <= 0 || numbers.length > 13) {
            return false;
        }
        // 分开存数字和大小王
        List<Integer> listKing = new ArrayList<>();
        List<Integer> listNumber = new ArrayList<>();
        for (int i : numbers) {
            if (i == 0) {
                listKing.add(i);
            } else {
                listNumber.add(i);
            }
        }
        Collections.sort(listNumber);
        // 全是王和只有一个数字1时
        if (listNumber.size() <= 1) {
            return true;
        }
        // 需要多少个大小王
        int temp = 0;
        for (int j = 1; j < listNumber.size(); j++) {
            // 当有重复时
            if (listNumber.get(j) - listNumber.get(j - 1) == 0) {
                return false;
            } else {
                temp += listNumber.get(j) - listNumber.get(j - 1) - 1;
            }
        }
        return temp <= listKing.size();
    }
}
