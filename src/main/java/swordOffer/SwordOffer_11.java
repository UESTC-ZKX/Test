package swordOffer;

/**
 * @ClassName SwordOffer_11
 * @Description: 第十一题
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 * 保证base和exponent不同时为0
 * @Author UESTC-ZKX
 * @Date 2020/1/24
 **/
public class SwordOffer_11 {
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (base == 0) {
            return 0;
        }
        double res = base;
        int e = exponent > 0 ? exponent : -exponent;
        while (e-- > 1) {
            res *= base;
        }
        return exponent > 0 ? res : 1 / res;
    }
}
