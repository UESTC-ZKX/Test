package dynamicProgram;

import swordOffer.MyUtils;

/**
 * @ClassName PackageProblem
 * @Description:
 * 0-1背包问题--回溯法
 * 给定n种物品和一背包。物品i的重量是wi，其价值为pi，背包的容量为C。
 * 问应如何选择装入背包的物品，使得装入背包中物品的总价值最大?
 * @Author UESTC-ZKX
 * @Date 2020/2/12
 **/
public class PackageProblem {
    MyUtils myUtils = new MyUtils();

    // 初始值
    private int n, c;
    private int[] wi, pi;
    // 最优价值
    private int bestValue = 0;
    // 最优解
    private int[] bestX;
    // 当前解
    private int[] x;
    // 当前重量，当前价值
    private int weight = 0, value = 0;

    /**
     * 找最大物品价值
     * @param n  物品数量(为数组长度)
     * @param wi 物品重量数组
     * @param pi 物品价值数组
     * @param c  背包容量
     * @return
     */
    public int findMaxValue(int n, int[] wi, int[] pi, int c){
        int res = 0;
        if(myUtils.isNull(n, c) || n == 0){
            return res;
        }
        // 初始化参数
        this.n = n;
        this.c = c;
        this.wi = wi;
        this.pi = pi;
        bestValue = 0;
        bestX = new int[n];
        x = new int[n];
        // 从0开始
        backtrack(0);
        res = bestValue;
        return res;
    }

    /**
     * 递归回溯方法
     * @param t 当前物品
     */
    private void backtrack(int t){
        // 递归终止条件（遍历完）
        if(t > n-1){
            // 找到更优解
            if (value > bestValue){
                bestValue = value;
                for(int i = 0; i < n; i++){
                    bestX[i] = x[i];
                }
            }
            return;
        }
        // 未遍历完时，分为2种情况（0不装, 1装入）
        // 不装入
        x[t] = 0;
        backtrack(t+1);
        // 装入
        x[t] = 1;
        // 装的下时
        if(weight + wi[t] <= c){
            weight += wi[t];
            value += pi[t];
            backtrack(t+1);
            // 回溯之前的状态
            weight -= wi[t];
            value -= pi[t];
        }
    }
}
