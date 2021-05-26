package test.huawei.nowcoder;

import java.util.*;

/**
 * @author zhoukx
 * @ClassName: Test31
 * @description:
 * 题目描述
 * 对字符串中的所有单词进行倒排。
 *
 * 说明：
 *
 * 1、构成单词的字符只有26个大写或小写英文字母；
 *
 * 2、非构成单词的字符均视为单词间隔符；
 *
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 *
 * 4、每个单词最长20个字母；
 * 输入描述:
 * 输入一行以空格来分隔的句子
 *
 * 输出描述:
 * 输出句子的逆序
 *
 * 示例1
 * 输入
 * I am a student
 * 输出
 * student a am I
 * 示例2
 * 输入
 * $bo*y gi!r#l
 * 输出
 * l r gi y bo
 * @date 2021/5/22
 */
public class Test31 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();


        ArrayList<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for(char c : string.toCharArray()){
            if(c >= 'A' && c <= 'z'){
                stringBuilder.append(c);
            }
            else {
                if(stringBuilder.length() > 0) {
                    list.add(stringBuilder.toString());
                }
                stringBuilder.setLength(0);
            }
        }
        list.add(stringBuilder.toString());
        stringBuilder.setLength(0);
        for(int i = list.size() - 1 ; i >= 0 ; i--){
            stringBuilder.append(list.get(i)).append(" ");
        }
        if(stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        System.out.println(stringBuilder);
    }
}
