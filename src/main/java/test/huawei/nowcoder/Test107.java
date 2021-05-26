package test.huawei.nowcoder;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author zhoukx
 * @ClassName: Test107
 * @description:
 * 题目描述
 * 计算一个数字的立方根，不使用库函数。
 * 保留一位小数。
 *
 *
 * 输入描述:
 * 待求解参数，为double类型（一个实数）
 *
 * 输出描述:
 * 输入参数的立方根。保留一位小数。
 *
 * 示例1
 * 输入
 * 216
 * 输出
 * 6.0
 * @date 2021/5/22
 */
public class Test107 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double res = 0;
        if(x >= 1) {
            res = method(0, x, x);
        }
        else if(x > -1 && x < 1){
            res = method(-1, 1, x);
        }
        else {
            res = method(x, 0, x);
        }
        System.out.printf("%.1f", res);
    }

    public static double method(double left , double right, double x){
        double helf = (left + right) / 2;
        double temp = helf * helf * helf;
        BigDecimal tempBd = new BigDecimal(temp);
        BigDecimal xBd = new BigDecimal(x);

        double temp1 = tempBd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        double x1 = xBd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        if(temp1 == x1){
            return helf;
        }else {
            if (temp > x) {
                return method(left, helf, x);
            }
            else{
                return method(helf, right, x);
            }
        }
    }
}
