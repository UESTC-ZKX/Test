package swordOffer;

import java.util.HashSet;

/**
 * @ClassName SwordOffer_37
 * @Description: 第三十七题
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，
 * 保证传入数据是正确的）
 * @Author UESTC-ZKX
 * @Date 2020/2/15
 **/
public class SwordOffer_37 extends MyClass {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (pHead1 != null) {
            set.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (set.contains(pHead2)) {
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }

}
