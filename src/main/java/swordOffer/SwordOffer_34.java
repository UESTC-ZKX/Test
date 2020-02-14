package swordOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @ClassName SwordOffer_34
 * @Description:
 * 第三十四题
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @Author UESTC-ZKX
 * @Date 2020/2/14
 **/
public class SwordOffer_34 {

    // 丑数×2，3，5，还是丑数
    public int GetUglyNumber_Solution(int index) {
        if(index < 1){
            return 0;
        }
        int[] res = new int[index];
        res[0] = 1;
        int index2=0,index3=0,index5=0;
        for(int i = 1; i < index; i++){
            res[i] = Math.min(res[index2]*2,Math.min(res[index3]*3, res[index5]*5));
            if(res[i] == res[index2]*2)index2++;
            if(res[i] == res[index3]*3)index3++;
            if(res[i] == res[index5]*5)index5++;
        }
        return res[index-1];
    }

    /* 超时法···*/
//    public int GetUglyNumber_Solution(int index) {
//        int res = 0;
//        int i = 1;
//        while (index > 0){
//            while (true){
//                if(isUglyNumber(i)){
//                    res = i;
//                    index--;
//                    i++;
//                    break;
//                }
//                i++;
//            }
//        }
//        return res;
//    }
//
//    /**
//     * 判断 n 是否是丑数
//     * @param   n 输入
//     * @return
//     */
//    private boolean isUglyNumber(int n){
//        if(n < 1){
//            return false;
//        }
//        if(n <= 5){
//            return true;
//        }
//        if(isPrimes(n)){
//            return false;
//        }
//        for (int i = n - 1; i > 5; i--){
//            if (n % i == 0){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    /**
//     * 判断 n 是否是素数
//     * @param   n 输入
//     * @return
//     */
//    private boolean isPrimes(int n){
//        if(n < 1){
//            return false;
//        }
//        if(n <= 2){
//            return true;
//        }
//        for (int i = n-1; i > 1; i--){
//            if(n % i == 0){
//                return false;
//            }
//        }
//        return true;
//    }
}
