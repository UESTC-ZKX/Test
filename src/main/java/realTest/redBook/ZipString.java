package realTest.redBook;

import java.util.Scanner;

/**
 * @ClassName ZipString
 * @Description: 压缩字符串
 * 输入一串字符，请编写一个字符串压缩程序，将字符串中连续出现的重复字母进行压缩，并输出压缩后的字符串。
 * 例如：
 * aac 压缩为 1ac
 * xxxxyyyyyyzbbb 压缩为 3x5yz2b
 * <p>
 * <p>
 * 输入描述:
 * 任意长度字符串
 * <p>
 * 输出描述:
 * 压缩后的字符串
 * <p>
 * 输入例子1:
 * xxxxyyyyyyzbbb
 * <p>
 * 输出例子1:
 * 3x5yz2b
 * @Author UESTC-ZKX
 * @Date 2020/2/25
 **/
public class ZipString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        scanner.close();
        StringBuilder res = new StringBuilder();
        if (string.length() == 0) {
            return;
        }
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = i + 1;
            if (j < chars.length && chars[i] == chars[j]) {
                while (j < chars.length && chars[i] == chars[j]) {
                    j++;
                }
                res.append(j - i - 1).append(chars[i]);
                i = j - 1;
            } else {
                res.append(chars[i]);
            }
        }
        System.out.println(res);
    }


}
