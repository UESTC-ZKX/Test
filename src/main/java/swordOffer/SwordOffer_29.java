package swordOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SwordOffer_29
 * @Description:
 * 第二十九题
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @Author UESTC-ZKX
 * @Date 2020/2/12
 **/
public class SwordOffer_29 {
    MyUtils myUtils = new MyUtils();
    public int MoreThanHalfNum_Solution(int [] array) {
        int res = 0;
        if (myUtils.isNull(array) || array.length == 0){
            return res;
        }
        int bestNum = array[0],bestTimes = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
                if(map.get(i) >= bestTimes){
                    bestNum = i;
                    bestTimes = map.get(i);
                }
            }
            else {
                map.put(i, 1);
            }
        }
        if(bestTimes > array.length/2){
            return bestNum;
        }
        else{
            return 0;
        }
    }
}
