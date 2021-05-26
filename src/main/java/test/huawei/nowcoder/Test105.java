package test.huawei.nowcoder;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * @author zhoukx
 * @ClassName: Test105
 * @description:
 * 题目描述
 * 从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
 * 本题有多组输入数据，输入到文件末尾，请使用while(cin>>)读入
 * 数据范围小于1e6
 * 输入描述:
 * 输入任意个整数，每行输入一个。
 *
 * 输出描述:
 * 输出负数个数以及所有非负数的平均值
 *
 * 示例1
 * 输入
 * -13
 * -4
 * -7
 * 输出
 * 3
 * 0.0
 * @date 2021/5/23
 */
public class Test105 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // 1非负，2负
        int sum1 = 0;
        int count1 = 0;
        int count2 = 0;
        BigDecimal res = BigDecimal.ZERO;

        while (scanner.hasNext()){
            int i = scanner.nextInt();
            if(i >= 0){
                sum1 += i;
                count1++;
            }
            else {
                count2++;
            }
        }
        System.out.println(count2);
        if(count1 > 0){
            BigDecimal sum = new BigDecimal(sum1);
            BigDecimal count = new BigDecimal(count1);
            res = sum.divide(count, ROUND_HALF_UP);
        }
        System.out.printf(String.valueOf(res.setScale(1)));
    }

}
