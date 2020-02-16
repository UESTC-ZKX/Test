package swordOffer;

import java.util.HashMap;

/**
 * @ClassName SwordOffer_40
 * @Description:
 * 第四十题
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * @Author UESTC-ZKX
 * @Date 2020/2/16
 **/
public class SwordOffer_40 {

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array.length == 0){
            return ;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else {
                map.put(i,1);
            }
        }
        boolean isFirst = true;
        for(int i : array){
            if (map.get(i) == 1){
                if(isFirst) {
                    num1[0] = i;
                    isFirst = false;
                }else {
                    num2[0] = i;
                    break;
                }
            }
        }
    }
}
