package swordOffer;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName SwordOffer_45
 * @Description: 第四十五题
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,
 * 今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,
 * 然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 * 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * 如果没有小朋友，请返回-1
 * @Author UESTC-ZKX
 * @Date 2020/2/18
 **/
public class SwordOffer_45 extends MyClass {

    // 暴力法
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        // 利用循环链表
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int i = 1; i < n; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        temp.next = head;
        // 计数器
        int key = 0;
        ListNode pre = head;
        while (!head.equals(head.next)) {
            if (key == m - 1) {
                key = 0;
                pre.next = head.next;
                head = head.next;
            } else {
                pre = head;
                head = head.next;
                key++;
            }
        }
        return head.val;
    }

    // 数学归纳法
    // 用数学归纳法推导出递推公式，设有n个人（编号0~(n-1))，
    // 从0开始报数，报到(m-1)的退出，剩下的人继续从0开始报数。
    // 令f[i]表示i个人时最后胜利者的编号，则有递推公式：
    // f[1]=0;
    // f[i]=(f[i-1]+m)%i; (i>1)
    // 原文链接：https://blog.csdn.net/crazy__chen/article/details/45115911
    public int LastRemaining_Solution_1(int n, int m) {
        if (n == 0) return -1;
        int s = 0;
        for (int i = 2; i <= n; i++) {
            s = (s + m) % i;
        }
        return s;
    }
}
