package realTest.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName EmptyBottle
 * @Description: 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。
 * 小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”
 * 答案是5瓶，方法如下：
 * 先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，
 * 用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
 * 然后你让老板先借给你一瓶汽水，喝掉这瓶满的，
 * 喝完以后用3个空瓶子换一瓶满的还给老板。
 * 如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 * <p>
 * 输入描述:
 * 输入文件最多包含10组测试数据，
 * 每个数据占一行，仅包含一个正整数n（1<=n<=100），
 * 表示小张手上的空汽水瓶数。n=0表示输入结束，你的程序不应当处理这一行。
 * <p>
 * 输出描述:
 * 对于每组测试数据，
 * 输出一行，表示最多可以喝的汽水瓶数。
 * 如果一瓶也喝不到，输出0。
 * <p>
 * 输入例子1:
 * 3
 * 10
 * 81
 * 0
 * <p>
 * 输出例子1:
 * 1
 * 5
 * 40
 * @Author UESTC-ZKX
 * @Date 2020/2/26
 **/
public class EmptyBottle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            int n = Integer.parseInt(scanner.nextLine());
            if (n == 0) {
                break;
            }
            list.add(n);
        }
        for (int i : list) {
            System.out.println(handle(i));
        }
    }

    /**
     * 空瓶换的汽水数
     *
     * @param n 空瓶数
     * @return
     */
    private static int handle(int n) {
        int empty = n;
        int res = 0;
        while (empty > 2) {
            res += empty / 3;
            empty = empty / 3 + empty % 3;
        }
        if (empty == 2) {
            return res + 1;
        } else {
            return res;
        }
    }

    // TODO 两个空瓶换一个满地

}
