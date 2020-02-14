package realTest.bilibili;

import java.util.Scanner;

/**
 * @ClassName ArraysArrangedMin
 * @Description:
 * 数组排成最小的数
 * 输入一个正整数数组，将它们连接起来排成一个数，输出能排出的所有数字中最小的一个。
 *
 * 输入描述:
 * 一行输入，数组中的数字用逗号隔开。例如：
 *
 * 输入为：
 *
 * 32,231
 *
 * 则表示数组{32, 231}
 *
 * 输出描述:
 * 直接输出最小数字即可，如示例题目中，输出为：
 *
 * 23132
 *
 * 输入例子1:
 * 32,231
 *
 * 输出例子1:
 * 23132
 * @Author UESTC-ZKX
 * @Date 2020/2/14
 **/
public class ArraysArrangedMin {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(",");
        scanner.close();
        if(strings.length == 0 || strings == null){
            return;
        }
        mySort(strings);
        StringBuilder res = new StringBuilder();
        for(String s : strings){
            res.append(s);
        }
        System.out.println(res);
    }

    /**
     * 自定义排序，（升序）
     * @param strings 输入
     */
    private static void mySort(String[] strings){
        for(int i = 0; i < strings.length; i++){
            for(int j = i+1; j < strings.length; j++){
                if(isALessThanB(strings[j], strings[i])){
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
            }
        }
    }

    /**
     * 判断ab是否小于ba
     * @param a 输入
     * @param b 输入
     * @return bollean
     */
    private static boolean isALessThanB(String a, String b){
        if(Long.parseLong(a+b) < Long.parseLong(b+a)){
            return true;
        }
        return false;
    }

}
