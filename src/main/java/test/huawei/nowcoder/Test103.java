package test.huawei.nowcoder;

import java.util.Scanner;

/**
 * @author zhoukx
 * @ClassName: Test103
 * @description:
 * 题目描述
 * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
 *
 * 本题含有多组样例输入
 *
 *
 * 输入描述:
 * 输入多组数据，1组有2行，第1行先输入数组的个数，第2行再输入梅花桩的高度
 *
 * 输出描述:
 * 一组输出一个结果
 *
 * 示例1
 * 输入
 * 6
 * 2 5 1 5 4 5
 * 3
 * 3 2 1
 * 输出
 * 3
 * 1
 * 说明
 * 6个点的高度各为 2 5 1 5 4 5
 * 如从第1格开始走,最多为3步, 2 4 5
 * 从第2格开始走,最多只有1步,5
 * 而从第3格开始走最多有3步,1 4 5
 * 从第5格开始走最多有2步,4 5
 * 所以这个结果是3。
 * @date 2021/5/24
 */
public class Test103 {


    private static int count = 1;
    private static int max = 1;
    private static int curIndex = 0;
    private static int nextIndex = 1;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // dp[i] 为走到i最多的步数 0 < j < i
        // dp[i] = max(dp[i], dp[j] + 1)


        // 暴力回溯
        while (scanner.hasNext()){
            String temp = scanner.nextLine();
            String[] strings = scanner.nextLine().split(" ");
            backtrak(strings);
            System.out.println(max);
            // 重置
            count = 1;
            max = 1;
            curIndex = 0;
            nextIndex = 1;
        }

    }

    static void backtrak(String[] strings){

        boolean needBack = false;

        // 初始位置
        int temp1 = curIndex, temp2 = nextIndex;

        // 终止条件1
        if(curIndex >= strings.length - 1 || nextIndex >= strings.length - 1){
            if(nextIndex == curIndex + 1 && Integer.parseInt(strings[curIndex]) < Integer.parseInt(strings[nextIndex])){
                count++;
            }
            max = Math.max(count, max);
            return;
        }
        int cur = Integer.parseInt(strings[curIndex]);
        int next = Integer.parseInt(strings[nextIndex]);

        nextIndex++;
        backtrak(strings);
        if(cur < next){
            curIndex = nextIndex;
            count++;
            backtrak(strings);
            count--;
            curIndex = temp1+1;
            nextIndex = temp2+1;
        }
    }
}
