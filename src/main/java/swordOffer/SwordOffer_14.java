package swordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SwordOffer_14
 * @Description:
 * 第十四题
 * 输入一个整数数组，
 * 实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @Author UESTC-ZKX
 * @Date 2020/1/25
 **/
public class SwordOffer_14 {
    MyUtils myUtils = new MyUtils();
    public void reOrderArray(int [] array) {
        if(myUtils.isNull(array)){
            return;
        }
        List<Integer> evenList = new ArrayList<Integer>();
        List<Integer> oddList = new ArrayList<Integer>();
        for (int i : array){
            if(i % 2 == 0){
                evenList.add(i);
            }
            else {
                oddList.add(i);
            }
        }
        oddList.addAll(evenList);
        for(int i = 0; i < array.length; i++){
            array[i] = oddList.get(i);
        }
    }
}
