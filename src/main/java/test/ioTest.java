package test;

import java.util.Scanner;

/**
 * @ClassName ioTest
 * @Description: TODO
 * @Author UESTC-ZKX
 * @Date 2020/2/12
 **/
public class ioTest {
    public static void main(String[] args) {
        System.out.println("输入");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        int[] array = new int[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
            System.out.println(array[i]);
        }
    }
}
