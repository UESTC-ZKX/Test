package swordOffer;

/**
 * @ClassName SwordOffer_32
 * @Description: 第三十二题
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * @Author UESTC-ZKX
 * @Date 2020/2/13
 **/
public class SwordOffer_32 {

    // 暴力法
    public int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            char[] chars = (i + "").toCharArray();
            for (char c : chars) {
                if (c == '1') {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 个位数上的1的个数：(n/10)*1 + (n%10)<1 ? 0 : (n%10 ≥ 2 ? 1 : (n%10-1)+1)
     * 十位数上的1的个数：(n/100)*10 + (n%100)<10 ? 0 : (n%100 ≥ 20 ? 10 : ( n%100-10)+1 )
     * 百位数上1的个数：(n/1000)*100 + (n%1000)<100 ? 0 : (n%1000 ≥ 200 ? 100 : (n%1000-100)+1)
     * 总计i：(n/(10i))i + (n%(10i))< i ? 0 : (n%10i ≥ 2i ? i : (n%10i-i)+1)
     */
    public int NumberOf1Between1AndN_Solution_1(int n) {
        int res = 0;
        for (int i = 1; i <= n; i *= 10) {
            res += n / (i * 10) * i + (n % (i * 10) < i ? 0 : (n % (10 * i) >= 2 * i ? i : (n % (10 * i) - i + 1)));
        }
        return res;
    }
}
