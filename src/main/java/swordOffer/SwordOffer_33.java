package swordOffer;


/**
 * @ClassName SwordOffer_33
 * @Description: 第三十三题
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @Author UESTC-ZKX
 * @Date 2020/2/13
 **/
public class SwordOffer_33 {
    public String PrintMinNumber(int[] numbers) {
        StringBuilder res = new StringBuilder();
        if (numbers == null || numbers.length == 0) {
            return res.toString();
        }
        sort(numbers);
        for (int i : numbers) {
            res.append(i);
        }
        return res.toString();
    }

    // 自定义排序函数
    private void sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (isBLessThanA(numbers[i], numbers[j])) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    // 自定义比较函数
    private boolean isBLessThanA(int a, int b) {
        // tempA=ab,tempB=ba;
        long tempA = Long.parseLong((a + "") + (b + ""));
        long tempB = Long.parseLong((b + "") + (a + ""));
        if (tempB < tempA) {
            return true;
        } else {
            return false;
        }
    }
}
