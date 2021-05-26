package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * @author zhoukx
 * @ClassName: test2
 * @description: TODO
 * @date 2021/5/2
 */
public class test2 {


    public static void main(String[] args){

        int i = 10000;

        // a记录为75的次数，b记录非75的次数
        int a = 0;
        int b = 0;

        while (i-- > 0){
            int t = test();
            if(t == 30){
                a++;
            }
            else {
                b++;
            }
        }
        System.out.println("75出现的次数为：" + a + "\n不是75出现的次数为：" + b);
    }

    // 一次实验
    private static int test(){
        int i = 4;
        int sum = 0;
        while (i-- > 0){
            sum += getBall((int) (Math.random() * 10000));
        }
        return sum;
    }

    // 获取球上的编号
    public static int getBall(int r){
        // 获取随机数
        return r < 5000 ? 5 : 10;
    }

}
