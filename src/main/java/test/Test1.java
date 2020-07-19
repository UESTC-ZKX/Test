package test;

import java.util.*;

/**
 * @ClassName Test
 * @Description:
 * @Author UESTC-ZKX
 * @Date 2020/2/25
 **/
public class Test1 {

    // 链表节点
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int n = Integer.parseInt(string);
        String string1 = Integer.toBinaryString(n);

        System.out.println(string1);
        scanner.close();
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        if ("".equals(s)) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.empty()) {
                if (map.get(c) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkSam(String stringA, String stringB) {
        // write code here
        String[] stringsA = stringA.split(" ");
        String[] stringsB = stringB.split(" ");
        if (stringsA.length != stringsB.length && stringsA.length == 0) {
            return false;
        }
        Arrays.sort(stringsA);
        Arrays.sort(stringsB);
        for (int i = 0; i < stringsA.length; i++) {
            if (!stringsA[i].equals(stringsB[i])) {
                return false;
            }
        }
        return true;
    }

    public int longestValidParentheses(String s) {

        Stack<Character> stack = new Stack<>();
        int cur = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(c);
            } else {
                if (c == ')' && '(' == stack.peek()) {
                    stack.pop();
                    cur += 2;
                } else {
                    stack.push(c);
                }
            }
        }
        max = Math.max(max, cur);
        return max;
    }


    public ArrayList<String> getSolution(int n) {
        // write code here
        move(n, "left", "mid", "right");
        return arrayList;
    }

    private ArrayList<String> arrayList = new ArrayList<>();

    /**
     * 把n个从第一个移到第三个上
     *
     * @param n     n
     * @param left  第一个柱子
     * @param mid   第二个柱子(暂存用)
     * @param right 第三个柱子
     */
    private void move(int n, String left, String mid, String right) {
        // 递归终止条件
        if (n <= 1) {
            arrayList.add("move from " + left + " to " + right);
        } else {
            // 先把n-1个移到第二个柱子上
            move(n - 1, left, right, mid);
            // 移动第n个到三号柱子上
            arrayList.add("move from " + left + " to " + right);
            // 把n-1个再移到第3个柱子上
            move(n - 1, mid, left, right);
        }
    }

    public ListNode detectCycle(ListNode pHead) {

        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode listNode1 = pHead, listNode2 = pHead;
        // 第一次相遇点
        while (listNode1 != null && listNode2 != null && listNode2.next != null) {
            listNode1 = listNode1.next;
            listNode2 = listNode2.next.next;
            if (listNode1 == listNode2) {
                listNode1 = pHead;
                break;
            }
        }
        // 同速从相遇点和头节点出发，再次相遇点为环的起点
        while (listNode1 != null || listNode2 != null) {
            if (listNode1 == listNode2) {
                return listNode1;
            }
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        return null;

    }

    /**
     * 返回两个数组中相同数字不相交的最大连线数
     *
     * @param A int整型一维数组 整数集合A
     * @param B int整型一维数组 整数集合B
     * @return int整型
     */
    public int maxUncrossedLines(int[] A, int[] B) {
        // write code here
        arrayA = A;
        arrayB = B;
        backtrack(0, 0);
        return max;
    }

    private int max = 0, cur = 0;
    private int[] arrayA, arrayB;

    private void backtrack(int i, int j) {
        // 递归终止条件
        if (i >= arrayA.length || j >= arrayB.length) {
            max = Math.max(max, cur);
            return;
        }
        // 不选择i
        backtrack(i + 1, j);
        // 选择i时
        while (j < arrayB.length && arrayA[i] != arrayB[j]) {
            j++;
        }
        //if(j <= arrayB.length) {
        cur++;
        //}
        backtrack(i + 1, j + 1);
        // 回溯
        cur--;
    }

    /**
     * @param s string字符串
     * @return string字符串
     */
    public String minRemove(String s) {
        // write code here
        Stack<temp> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ('(' == c || ')' == c) {
                if (!stack.empty() && (c == ')' && '(' == stack.peek().c)) {
                    stack.pop();
                } else {
                    stack.push(new temp(c, i));
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        while (!stack.empty()) {
            set.add(stack.pop().index);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (!set.contains(i)) {
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }

    class temp {
        char c;
        int index;

        temp(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }


}
