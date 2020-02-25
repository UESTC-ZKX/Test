package test;

import java.util.*;
/**
 * @ClassName Test
 * @Description:
 * java中进行二进制，八进制，十六进制，十进制间进行相互转换      
 * 十进制转成十六进制：
 * Integer.toHexString(int i)
 * 十进制转成八进制
 * Integer.toOctalString(int i)
 * 十进制转成二进制
 * Integer.toBinaryString(int i)
 * 十六进制转成十进制
 * Integer.valueOf("FFFF",16).toString()
 * 八进制转成十进制
 * Integer.valueOf("876",8).toString()
 * 二进制转十进制
 * Integer.valueOf("0101",2).toString()
 *
 * 有什么方法可以直接将2,8,16进制直接转换为10进制的吗?
 * java.lang.Integer类
 * parseInt(String s, int radix)
 * 使用第二个参数指定的基数，将字符串参数解析为有符号的整数。
 * @Author UESTC-ZKX
 * @Date 2020/2/25
 **/
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String[] strings = scanner.nextLine().split(" ");
            long res = Long.parseLong(strings[0]) + Long.parseLong(strings[1]);
            System.out.println(res);
        }
        scanner.close();
    }
}
