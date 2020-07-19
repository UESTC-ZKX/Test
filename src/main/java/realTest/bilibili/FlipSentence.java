package realTest.bilibili;

import java.util.Scanner;

/**
 * @ClassName FlipSentence
 * @Description: 英文句子单词翻转
 * 原地翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 要求：空间复杂度O(1)，时间复杂度O(n)。
 * 输入描述:
 * 英文句子中单词以一个空格符隔开。为简单起见，标点符号和普通字母一样处理。
 * <p>
 * 输出描述:
 * 翻转之后的英文句子，单词内字符的顺序不变，以一个空格隔开。
 * <p>
 * 输入例子1:
 * I am a student.
 * <p>
 * 输出例子1:
 * student. a am I
 * @Author UESTC-ZKX
 * @Date 2020/2/14
 **/
public class FlipSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        scanner.close();
        for (int i = strings.length - 1; i >= 0; i--) {
            System.out.print(strings[i] + " ");
        }
    }
}
