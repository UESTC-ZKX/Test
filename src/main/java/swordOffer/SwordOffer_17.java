package swordOffer;

/**
 * @ClassName SwordOffer_17
 * @Description: 第十七题
 * 输入两个单调递增的链表，
 * 输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 * @Author UESTC-ZKX
 * @Date 2020/1/28
 **/
public class SwordOffer_17 extends MyClass {
    MyUtils myUtils = new MyUtils();

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (myUtils.isNull(list1, list2)) {
            if (myUtils.isNull(list1)) {
                return list2;
            } else {
                return list1;
            }
        }
        ListNode res, temp;
        if (list1.val < list2.val) {
            res = list1;
            list1 = list1.next;
        } else {
            res = list2;
            list2 = list2.next;
        }
        ListNode temp1 = list1, temp2 = list2;
        temp = res;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        }
        if (temp2 != null) {
            temp.next = temp2;
        }
        return res;
    }
}