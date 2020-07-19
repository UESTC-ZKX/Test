package realTest.huawei;

/**
 * @ClassName TakeUmbrella
 * @Description: 有T个人在食堂吃饭，出来的时候外面下雨了。
 * 现在他们想回办公室，但是手中只有一把伞，能载2人。
 * 办公室有小伞m把，大伞n把，小伞载2人，大伞载3人。
 * 他们决定去办公室取伞，一个人手里最多拿一把伞。
 * 从食堂到办公室要1个小时，从办公室到食堂也要1个小时。
 * 问：至少多久他们才能全部回办公室
 * @Author UESTC-ZKX
 * @Date 2020/2/22
 **/
public class TakeUmbrella {

    /**
     * f[n]为第n小时在公司的人数（从1开始）
     * 3*f[n-2]                    (f[n-2] < n) 都能拿大伞时
     * f[n] =    3*n + 2*(f[n-2]-n)          (n <= f[n-2] < n+m+1)大伞不够小伞多余时（开始手上的算小伞）
     * f[n-2] + 2*n + (m+1)        (n+m+1 <= f[n-2]) 满载时
     *
     * @param T 人数
     * @param m 小伞
     * @param n 大伞
     * @return 最短时间
     */
    public int minTime(int T, int m, int n) {
        if (T < 1 || m < 0 || n < 0) {
            return 0;
        }
        if (T <= 2) {
            return 1;
        }
        // 两小时前和当前和计时器
        int pre = 2, cur = 2, count = 1;
        while (cur < T) {
            pre = cur;
            if (pre < n) {
                cur = 3 * pre;
            }
            if (pre >= n && pre < n + m + 1) {
                cur = 3 * n + 2 * (pre - n);
            }
            if (pre >= n + m + 1) {
                cur = pre + 2 * n + (m + 1);
            }
            count = count + 2;
        }
        return count;
    }
}
