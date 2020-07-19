package test.huawei;

import java.util.Scanner;

/**
 * @ClassName Find101
 * @Description: 找整数转2进制中的101的次数和首次位置
 * (从右侧开始计算下标,示例给的5和21都是左右对称的,真的坑)
 * @Author UESTC-ZKX
 * @Date 2020/2/26
 **/
public class Find101 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        scanner.close();
        if ("".equals(string)) {
            return;
        }
        // TODO 异常处理 处理NumberFormatException
        int n = Integer.parseInt(string);
        String s;
        if (n < 0) {
            s = "1" + Integer.toBinaryString(-n);
        } else {
            s = Integer.toBinaryString(n);
        }
        int firstIndex = -1;
        int count = 0;

        for (int i = s.length(); i >= 3; i--) {
            if ("101".equals(s.substring(i - 3, i))) {
                if (firstIndex == -1) {
                    firstIndex = s.length() - i;
                }
                count++;
            }
        }
        System.out.println(count + " " + firstIndex);
    }
}
