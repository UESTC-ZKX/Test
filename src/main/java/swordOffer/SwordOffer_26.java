package swordOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SwordOffer_26
 * @Description:
 * 第二十六题
 * 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @Author UESTC-ZKX
 * @Date 2020/2/11
 **/
public class SwordOffer_26 extends MyClass{
    MyUtils myUtils = new MyUtils();
    public RandomListNode Clone(RandomListNode pHead) {
        if (myUtils.isNull(pHead)){
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode temp = pHead;
        while (temp != null){
            map.put(temp,new RandomListNode(temp.label));
            temp = temp.next;
        }
        temp = pHead;
        while (temp != null){
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(pHead);
    }
}


