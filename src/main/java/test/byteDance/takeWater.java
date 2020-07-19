package test.byteDance;

import java.util.Scanner;

/**
 * @ClassName takeWater
 * @Description: TODO
 * @Author UESTC-ZKX
 * @Date 2020/3/15
 **/
public class takeWater {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings1 = scanner.nextLine().split(" ");
        String[] strings2 = scanner.nextLine().split(" ");
        String[] strings3 = scanner.nextLine().split(" ");
        scanner.close();
        // 距离和初始水
        d = Integer.parseInt(strings1[0]);
        water = Integer.parseInt(strings1[1]);
        postion = new int[strings2.length];
        supply = new int[strings3.length];
        for(int i = 0; i < postion.length; i++) {
            postion[i] = Integer.parseInt(strings2[i]);
        }
        for(int i = 0; i < postion.length; i++) {
            supply[i] = Integer.parseInt(strings3[i]);
        }
        backtrack(0);
        System.out.println(mintimes);
    }
    // 总距离
    private static int d;
    // 当前次数
    private static int curtimes = 0;
    // 最小次数
    private static int mintimes = -1;
    private static int[] postion;
    private static int[] supply;
    // 已行进距离
    private static int length = 0;
    // 当前水量
    private static int water = 0;

    /**
     *
     * @param n 第几个水站
     */
    private static void backtrack(int n){
        // 递归终止条件,到达时
        if (n >= postion.length && water >= 0){
            if(mintimes == -1 && curtimes >= 0){
                mintimes = curtimes;
            }else {
                mintimes = Math.min(curtimes, mintimes);
            }
            return;
        }
        // 递归终止条件,没到时
        if (n >= postion.length){
            return;
        }
        // 不取水时
        int temp = 0;
        if(n+1 < postion.length) {
            temp = postion[n + 1] - postion[n];
            water -= temp;
        }
        else {
            temp = d - postion[n];
            water -= temp;
        }
        length += temp;
        backtrack(n+1);
        // 回溯
        water += temp;
        length -= temp;

        // 取水时
        curtimes++;
        temp = 0;
        if(n+1 < postion.length) {
            temp = postion[n + 1] - postion[n] - supply[n];
            water -= temp;
        }
        else {
            temp = d - postion[n] - supply[n];
            water -= temp;
        }
        length += temp;
        backtrack(n+1);
        // 回溯
        curtimes--;
        water += temp;
        length -= temp;
    }

}
