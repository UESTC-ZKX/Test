package example;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @ClassName CastExample
 * @Description: 遍历hashMap
 * Map map = new HashMap();
 * 　　Iterator iter = map.entrySet().iterator();
 * 　　while (iter.hasNext()) {
 * 　　Map.Entry entry = (Map.Entry) iter.next();
 * 　　Object key = entry.getKey();
 * 　　Object val = entry.getValue();
 * 　　}
 * <p>
 * java中进行二进制，八进制，十六进制，十进制间进行相互转换      
 * * 十进制转成十六进制：
 * * Integer.toHexString(int i)
 * * 十进制转成八进制
 * * Integer.toOctalString(int i)
 * * 十进制转成二进制
 * * Integer.toBinaryString(int i)
 * * 十六进制转成十进制
 * * Integer.valueOf("FFFF",16).toString()
 * * 八进制转成十进制
 * * Integer.valueOf("876",8).toString()
 * * 二进制转十进制
 * * Integer.valueOf("0101",2).toString()
 * *
 * * 有什么方法可以直接将2,8,16进制直接转换为10进制的吗?
 * * java.lang.Integer类
 * * parseInt(String s, int radix)
 * * 使用第二个参数指定的基数，将字符串参数解析为有符号的整数。
 * *
 * * BigInteger abs()  返回大整数的绝对值
 * * BigInteger add(BigInteger val) 返回两个大整数的和
 * * BigInteger and(BigInteger val)  返回两个大整数的按位与的结果
 * * BigInteger andNot(BigInteger val) 返回两个大整数与非的结果
 * * BigInteger divide(BigInteger val)  返回两个大整数的商
 * * double doubleValue()   返回大整数的double类型的值
 * * float floatValue()   返回大整数的float类型的值
 * * BigInteger gcd(BigInteger val)  返回大整数的最大公约数
 * * int intValue() 返回大整数的整型值
 * * long longValue() 返回大整数的long型值
 * * BigInteger max(BigInteger val) 返回两个大整数的最大者
 * * BigInteger min(BigInteger val) 返回两个大整数的最小者
 * * BigInteger mod(BigInteger val) 用当前大整数对val求模
 * * BigInteger multiply(BigInteger val) 返回两个大整数的积
 * * BigInteger negate() 返回当前大整数的相反数
 * * BigInteger not() 返回当前大整数的非
 * * BigInteger or(BigInteger val) 返回两个大整数的按位或
 * * BigInteger pow(int exponent) 返回当前大整数的exponent次方
 * * BigInteger remainder(BigInteger val) 返回当前大整数除以val的余数
 * * BigInteger leftShift(int n) 将当前大整数左移n位后返回
 * * BigInteger rightShift(int n) 将当前大整数右移n位后返回
 * * BigInteger subtract(BigInteger val)返回两个大整数相减的结果
 * * byte[] toByteArray(BigInteger val)将大整数转换成二进制反码保存在byte数组中
 * * String toString() 将当前大整数转换成十进制的字符串形式
 * * BigInteger xor(BigInteger val) 返回两个大整数的异或
 * @Author UESTC-ZKX
 * @Date 2020/1/22
 **/
public class CastExample {
    public static void main(String[] args) {
        int[] data = {4, 5, 3, 6, 2, 5, 1};
        /**
         *  int[] 转 List<Integer>
         *  Arrays.stream(arr) 可以替换成IntStream.of(arr)。
         *  1.使用Arrays.stream将int[]转换成IntStream。
         *  2.使用IntStream中的boxed()装箱。将IntStream转换成Stream<Integer>。
         *  3.使用Stream的collect()，将Stream<T>转换成List<T>，因此正是List<Integer>。
         */
        List<Integer> list1 = Arrays.stream(data).boxed().collect(Collectors.toList());

        /**
         * int[] 转 Integer[]
         * 前两步同上，此时是Stream<Integer>。
         * 然后使用Stream的toArray，传入IntFunction<A[]> generator。
         * 这样就可以返回Integer数组。
         * 不然默认是Object[]。
         */
        Integer[] integers1 = Arrays.stream(data).boxed().toArray(Integer[]::new);

        /**
         *  List<Integer> 转 Integer[]
         *  调用toArray。传入参数T[] a。这种用法是目前推荐的。
         *  List<String>转String[]也同理。
         */
        Integer[] integers2 = list1.toArray(new Integer[0]);

        /**
         *  List<Integer> 转 int[]
         *  想要转换成int[]类型，就得先转成IntStream。
         *  这里就通过mapToInt()把Stream<Integer>调用Integer::valueOf来转成IntStream
         *  而IntStream中默认toArray()转成int[]。
         */
        int[] arr1 = list1.stream().mapToInt(Integer::valueOf).toArray();

        /**
         *  Integer[] 转 int[]
         */
        int[] arr2 = Arrays.stream(integers1).mapToInt(Integer::valueOf).toArray();

        /**
         * Integer[] 转 List<Integer>
         * 思路同上。先将Integer[]转成Stream<Integer>，再转成IntStream。
         */
        List<Integer> list2 = Arrays.asList(integers1);

        /*********** 最简单的方式。String[]转List<String>也同理。***********/
        // 同理
        String[] strings1 = {"a", "b", "c"};
        // String[] 转 List<String>
        List<String> list3 = Arrays.asList(strings1);
        // List<String> 转 String[]
        String[] strings2 = list3.toArray(new String[0]);
    }
}

