package swordOffer;

/**
 * @ClassName SwordOffer_10
 * @Description:
 * 第十题
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @Author UESTC-ZKX
 * @Date 2020/1/23
 **/
public class SwordOffer_10 {
    public int NumberOf1(int n) {
        int res = 0;
        while (n != 0){
            n = n & (n-1);
            res++;
        }
        return res;
    }
}
