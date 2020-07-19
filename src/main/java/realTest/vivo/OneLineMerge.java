package realTest.vivo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OneLineMerge
 * @Description: 小v在vivo手机的应用商店中下载了一款名为“一维消消乐”的游戏，介绍如下：
 * 1、给出一些不同颜色的豆子，豆子的颜色用数字（0-9）表示，
 * 即不同的数字表示不同的颜色；
 * 2、通过不断地按行消除相同颜色且连续的豆子来积分，直到所有的豆子都消掉为止；
 * 3、假如每一轮可以消除相同颜色的连续 k 个豆子（k >= 1），
 * 这样一轮之后小v将得到 k*k 个积分；
 * 4、由于仅可按行消除，不可跨行或按列消除，因此谓之“一维消消乐”。
 * 请你帮助小v计算出最终能获得的最大积分。
 * <p>
 * 输入描述:
 * 输入一行n个正整数，代表这一行中豆子的颜色及排列。
 * <p>
 * 示例：
 * <p>
 * 输入：1 4 2 2 3 3 2 4 1
 * 输出：21
 * <p>
 * 示例说明：
 * 第一轮消除3，获得4分，序列变成1 4 2 2 2 4 1
 * 第二轮消除2，获得9分，序列变成1 4 4 1
 * 第三轮消除4，获得4分，序列变成1 1
 * 第四轮消除1，获得4分，序列为空
 * 总共得分21分
 * <p>
 * 输出描述:
 * 小V最终能拿到的最大积分。
 * <p>
 * 输入例子1:
 * 1 4 2 2 3 3 2 4 1
 * <p>
 * 输出例子1:
 * 21
 * @Author UESTC-ZKX
 * @Date 2020/3/7
 **/
public class OneLineMerge {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int[] input = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(int[] input) {
        // TODO 仅ac40%，只考虑了多个消除，忽略了单个自己消除
        merge(input);
        return maxValue;
    }

    private static int maxValue = 0;
    private static int curValue = 0;

    /**
     * 消除相同的数字
     *
     * @param input
     */
    private static void merge(int[] input) {
        // 递归终止条件
        if (isSame(input)) {
            curValue += Math.pow(input.length, 2);
            maxValue = Math.max(maxValue, curValue);
            return;
        }

        // 寻找可消除的点
        int left = 0;
        int right = left + 1;
        List<Node> list = new ArrayList<>();
        for (; right < input.length; right++) {
            if (input[left] != input[right]) {
                if (right - left > 1) {
                    list.add(new Node(left, right));
                }
                left = right;
            }
        }
        // 递归终止条件
        if (list.size() == 0) {
            maxValue = Math.max(maxValue, curValue + input.length);
            return;
        }
        for (Node node : list) {
            int[] temp = new int[input.length - (node.right - node.left)];
            int index = 0;
            for (int i = 0; i < node.left; i++, index++) {
                temp[index] = input[i];
            }
            for (int i = node.right; i < input.length; i++, index++) {
                temp[index] = input[i];
            }
            curValue += Math.pow((node.right - node.left), 2);
            merge(temp);
            // 回溯
            curValue -= Math.pow((node.right - node.left), 2);
        }
    }

    static class Node {
        int left;
        int right;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 是否全部相同
     *
     * @param input 输入数组
     * @return
     */
    private static boolean isSame(int[] input) {
        if (input.length < 2) {
            return false;
        } else {
            for (int i : input) {
                if (i != input[0]) {
                    return false;
                }
            }
            return true;
        }
    }
}
