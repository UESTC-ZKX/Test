package test.huawei;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName SaveString
 * @Description: 某程序员小A,
 * 有一种表格数据需要存储在文件中。
 * 表格中的每行,由若干个字骤组成,
 * 每个字段可以是整数字符串(字符包数字字母以及特殊字符!@#￥%……&*()",）。
 * 小A 设计了一种存储格式,采用文本的方式对表格数据进行存储。
 * 文本文件中的每行,代表了表格数据中的行数据。具体格式如下：
 *  1、采用号分隔不同的字段(逗号前后无空格);
 *  2、数字直接采用 10 进制的文本存储;
 *  3、字符串的存储规则如下：
 * <p>
 *   1)如果字符串中包含逗号以及双引号,
 * 则字符串必须在头尾各增加一个双引号,
 * 且中间的双引号需要用连续两个双引号来表示。例如:"a,""b",表示字符串 a,"b
 *   2)如果字符串中末包含逗号以及双引号,则字符串不强制要求在头尾增加双引号,
 * 可直接存储。例如:abc,或者"abc"都可以。
 *  4、空字符串不存储任何字符,例如:a,,b中,有3 个字段,分别为a,空字符串,b;
 * 请帮助小A 设计个算法,用来将单行文本,解析成多个字段,并输出。
 * <p>
 * 输入描述：
 * <p>
 *  用于存储单行表格数据的一行文本。
 *   1、用手分隔不同字段的号前后一定没有空格,程序设计者无需考虑此种异常情况
 *   2、除数字、字母以及特殊字符!@#￥%……&*()",外,不会出现其它字符
 *   3、输入的数字一定是 10 进制合法正整数,
 * 不会出现负数、小数、其它进制数以及格式错误的 10 进制数
 * <p>
 * 输出描述：
 * <p>
 * 第一行,字符串格式是否正确,正确输出字段个数,不正确输出ERROR。
 * 如果输入字符串格式不正确,则输出结束。
 * <p>
 * 如果字符串格式正确,则输出每个字段的值,每个字段单独占一行。
 * 数字采用 10 进制输出,字符串输出解析后的值。
 * <p>
 * 空字符串输出--
 * <p>
 * 示例输入：
 * <p>
 * a,,1,"b,"""
 * <p>
 * 示例输出：
 * <p>
 * 4
 * <p>
 * a
 * <p>
 * --
 * <p>
 * 1
 * <p>
 * b,"
 * @Author UESTC-ZKX
 * @Date 2020/2/26
 **/
public class SaveString {

    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String string = scanner.nextLine();
//        scanner.close();
//        List<String> stringList = new ArrayList<>();
//        // 出现‘，’的下标
//        List<Integer> indexList1 = new ArrayList<>();
//        // 出现‘"’的下标
//        List<Integer> indexList2 = new ArrayList<>();
//        string = ','+string+',';
//        for(int i = 0; i < string.length(); i++){
//            if(string.charAt(i) == ','){
//                indexList1.add(i);
//            }
//            if(string.charAt(i) == '"'){
//                indexList2.add(i);
//            }
//        }
//
//        int i = 0,j = 0;
//        while (i < indexList1.size()-1 && j < indexList2.size()){
//            if(indexList1.get(i+1) < indexList2.get(j)){
//                int left = indexList1.get(i)+1;
//                int right = indexList1.get(i+1);
//                if(right == left){
//                    stringList.add("--");
//                }else {
//                    stringList.add(string.substring(left, right));
//                }
//                i++;
//            }
//            int count = 0;
//            while (indexList1.get(i) < indexList2.get(j)&&indexList2.get(j) < indexList1.get(i+1)){
//                j++;
//                count++;
//            }
//            if(count % 2 == 1){
//                i++;
//            }
//            else {
//                StringBuilder temp = new StringBuilder();
//                for(int start = indexList1.get(i); start < indexList1.get(i+1); start++){
//                    if(count > 0 && string.charAt(start) == '"' &&string.charAt(start+1) =='"'){
//                        count = count-2;
//                        temp.append('"');
//                    }
//                    else {
//                        temp.append(string.charAt(start));
//                    }
//                }
//                stringList.add(temp+"");
//            }
//        }
//
//        System.out.println(stringList.size());
//        for(String s : stringList){
//            System.out.println(s);
//        }
//
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        scanner.close();

        if ("".equals(string) || string.length() == 0) {
            System.out.println("ERROR");
            return;
        }
        char[] chars = string.toCharArray();
        List<String> res = new ArrayList<>();

        // 暂存当前字符串
        StringBuilder stringBuilder = new StringBuilder();

        // 判断有没有被“”包围
        boolean key = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ',') {
                if (key) {
                    stringBuilder.append(chars[i]);
                } else {
                    res.add(stringBuilder.length() == 0 ? "--" : stringBuilder + "");
                    stringBuilder = new StringBuilder();
                }
            } else if (chars[i] == '"') {
                if (i + 1 < chars.length && chars[i + 1] == '"') {
                    stringBuilder.append('"');
                    i++;
                } else {
                    if (key) {
                        res.add(stringBuilder + "");
                        stringBuilder = new StringBuilder();
                        i++;
                        key = false;
                    } else {
                        key = true;
                    }
                }
            } else {
                stringBuilder.append(chars[i]);
            }
        }

        if (stringBuilder.length() > 0) {
            res.add(stringBuilder + "");
        }
        if (key) {
            System.out.println("ERROR");
        } else {
            for (String s : res) {
                System.out.println(s);
            }
        }
    }
}
