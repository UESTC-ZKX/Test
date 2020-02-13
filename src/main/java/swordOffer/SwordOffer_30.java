package swordOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @ClassName SwordOffer_30
 * @Description:
 * 第三十题
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4,。
 * @Author UESTC-ZKX
 * @Date 2020/2/12
 **/
public class SwordOffer_30 {
    MyUtils myUtils = new MyUtils();
    // 简单粗暴法
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (myUtils.isNull(input) || input.length == 0 || input.length < k){
            return res;
        }
        Arrays.sort(input);
        for(int i = 0; i < k; i++){
            res.add(input[i]);
        }
        return res;
    }

    // 维护一个长为k的有序数组，进行插入比较
    public ArrayList<Integer> GetLeastNumbers_Solution_1(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (myUtils.isNull(input) || input.length == 0 || input.length < k || k == 0){
            return res;
        }
        int[] array = new int[k];
        for(int i = 0; i < k; i++){
            array[i] = input[i];
        }
        Arrays.sort(array);
        for(int i = k; i < input.length; i++){
            if(array[k-1] > input[i]){
                array[k-1] = input[i];
                Arrays.sort(array);
            }
        }
        res = (ArrayList<Integer>) Arrays.stream(array).boxed().collect(Collectors.toList());
        return res;
    }

    // 维护一个有k个节点的大顶堆，和根节点比较，判断是否入堆,同理于FindTopKNumbers.findTopKNumbers()

}
