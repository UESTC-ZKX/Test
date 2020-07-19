package dynamicProgram;

/**
 * @ClassName HannoTower
 * @Description: 汉诺塔
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，
 * 盘子可以滑入任意一根柱子。
 * 一开始，所有盘子自上而下按升序依次套在第一根柱子上
 * (即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * <p>
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * @Author UESTC-ZKX
 * @Date 2020/2/26
 **/
public class HannoTower {

    private int count = 0;

    /**
     * 把n个从第一个移到第三个上
     *
     * @param n     n
     * @param one   第一个柱子
     * @param two   第二个柱子(暂存用)
     * @param three 第三个柱子
     */
    private void move(int n, int one, int two, int three) {
        count++;
        // 递归终止条件
        if (n <= 1) {
            System.out.println(one + " - > " + three);
        } else {
            // 先把n-1个移到第二个柱子上
            move(n - 1, one, three, two);
            // 移动第n个到三号柱子上
            System.out.println(one + " - > " + three);
            // 把n-1个再移到第3个柱子上
            move(n - 1, two, one, three);
        }
    }

    public int step(int n) {
        move(n, 1, 2, 3);
        return count;
    }

}
