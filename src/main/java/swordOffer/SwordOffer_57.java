package swordOffer;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName SwordOffer_57
 * @Description: 第五十七题
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @Author UESTC-ZKX
 * @Date 2020/2/19
 **/
public class SwordOffer_57 extends MyClass {

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode res = null, resTemp = null, temp = pHead;
        Map<Integer, Integer> map = new HashMap<>();
        while (temp != null) {
            if (map.containsKey(temp.val)) {
                map.put(temp.val, map.get(temp.val) + 1);
            } else {
                map.put(temp.val, 1);
            }
            temp = temp.next;
        }

        // 二次遍历
        temp = pHead;
        while (temp != null) {
            if (map.get(temp.val) == 1) {
                if (res == null) {
                    res = temp;
                    resTemp = temp;
                } else {
                    resTemp.next = temp;
                    resTemp = resTemp.next;
                }
            }
            temp = temp.next;
        }
        if (resTemp != null) {
            resTemp.next = null;
        }
        return res;
    }
}
