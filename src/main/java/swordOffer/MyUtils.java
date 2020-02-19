package swordOffer;

import java.util.*;

/**
 * @ClassName MyUtils
 * @Description:
 * 自定义工具类
 * @Author UESTC-ZKX
 * @Date 2020/1/21
 **/
public class MyUtils extends MyClass {

    final static int MAX = 1024 * 1024;

    /***************** 判空方法 *******************/
    // 输入判空方法 单值
    public boolean isNull(Object o){
        if(o == null){
            return true;
        }
        else {
            return false;
        }
    }

    // 双值
    public boolean isNull(Object o, Object o1){
        if(o == null || o1 == null){
            return true;
        }
        else {
            return false;
        }
    }

    // 三值
    public boolean isNull(Object o, Object o1,Object o2){
        if(o == null || o1 == null || o2 == null){
            return true;
        }
        else {
            return false;
        }
    }

    /************** 遍历二叉树 **************/
    /**
     * @param treeNode 根节点
     * @param state 遍历状态 ：PRE 前序，IN 中序，POST 后序，LEVEL 层序
     * @return 遍历结果集
     */
    public List<Integer> traversal(TreeNode treeNode, String state){
        // 遍历结果list
        List<Integer> list = new ArrayList<>();
        switch (state){
            case "PRE":
                preTraversal(treeNode, list);break;
            case "IN":
                inTraversal(treeNode,list);break;
            case " POST":
                postTraversal(treeNode, list);break;
            case "LEVEL":
                levelTraversal(treeNode, list);break;
        }
        return list;
    }

    // 层序遍历二叉树
    private void levelTraversal(TreeNode treeNode, List list){
        if(isNull(treeNode)){
            return;
        }
        Queue<TreeNode> queue = new LinkedList();
        while (!isNull(treeNode)) {
            if (!isNull(treeNode.left)) {
                queue.offer(treeNode.left);
            }
            if (!isNull(treeNode.right)) {
                queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
            treeNode = queue.poll();
        }
    }

    // 前序遍历二叉树
    private  void preTraversal(TreeNode treeNode, List list){
        if(isNull(treeNode)){
            return;
        }
        list.add(treeNode.val);
        preTraversal(treeNode.left,list);
        preTraversal(treeNode.right,list);
    }

    // 中序遍历二叉树
    private void inTraversal(TreeNode treeNode, List list){
        if(isNull(treeNode)){
            return;
        }
        inTraversal(treeNode.left,list);
        list.add(treeNode.val);
        inTraversal(treeNode.right,list);
    }

    // 后序遍历
    private void postTraversal(TreeNode treeNode, List list){
        if(isNull(treeNode)){
            return;
        }
        postTraversal(treeNode.left,list);
        postTraversal(treeNode.right,list);
        list.add(treeNode.val);
    }

    /**************** 排序方法 *****************/
    // 自定义排序,数据量小时用快排，多时用归并排序
    public void mySort(int[] array){
        if(array.length < MAX){ quickSortByRecursion(array,0,array.length-1); }
        else { mergeSort(array, 0, array.length-1);}
    }

    // 快速排序-递归实现
    private void quickSortByRecursion(int[] array, int left, int right){
        // 递归终止条件
        if(left >= right || isNull(array)){
            return;
        }
        // 所选的点
        int key = array[left];
        int l = left;
        int r = right;
        while (l < r){
            while (l < r && array[r] >= key){
                r--;
            }
            while (l < r && array[l] <= key){
                l++;
            }
            int temp = array[r];
            array[r] = array[l];
            array[l] = temp;
        }
        array[left] = array[l];
        array[l] = key;
        quickSortByRecursion(array,left,l-1);
        quickSortByRecursion(array,l+1,right);
    }

    // TODO 快速排序-非递归实现 利用栈存left和right
    public static void quickSortByStack(int[] array ){
        //创建类保存开始结束索引

        //创建list 模拟栈，先入后出
        LinkedList<int[]> stack = new LinkedList<>();
        //加入初始数据，第一次执行
        stack.addFirst(new int[]{0, array.length - 1});
        //循环执行栈内的数据，直至排序完成
        while (!stack.isEmpty()) {
            int[] tuple = stack.removeFirst();
            int start = tuple[0], end = tuple[1], i = tuple[0], j = tuple[1];

            while (j > i) {
                //从右边开始找到一个大于第0 位数的数，也可能找不到
                while (j > i && array[j] > array[start]) {
                    j--;
                }
                //从左边查找第一个小于第 0 位的数，也可能找不到
                while (j > i && array[i] <= array[start]) {
                    i++;
                }
                //i j 不是同一个数就交换，找不到的情况下 i j 是一样的，这是就不用交换了
                if (j > i) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
            if (start != i) {
                int temp = array[start];
                array[start] = array[i];
                array[i] = temp;
            }

            if (i - 1 > start) {
                stack.addFirst(new int[]{0, i - 1});
            }
            if (j + 1 < end) {
                stack.addFirst(new int[]{j + 1, end});
            }

        }
    }

    // 归并排序
    private void mergeSort(int[] array, int left, int right){
        // 递归结束条件
        if(left >= right || isNull(array)){
            return;
        }
        int mid = (left + right)/2;
        mergeSort(array,left,mid);
        mergeSort(array,mid+1,right);
        merge(array,left, mid, right);
    }
    private void merge(int[] array, int left, int mid, int right){
        if(right-left < 1){
            return;
        }
        // 辅助数组
        int[] temp = new int[right - left + 1];
        int index = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right){
            if(array[i] <= array[j]){
                temp[index++] = array[i++];
            }
            else {
                temp[index++] = array[j++];
            }
        }
        while (i <= mid){
            temp[index++] = array[i++];
        }
        while (j <= right){
            temp[index++] = array[j++];
        }
        for(index = 0; index < temp.length; index++){
            array[left + index] = temp[index];
        }
    }

    /******************* 链表 ********************/
    // 单向链表
    public int[] linkListToArray(ListNode head){
        List<Integer> list = new ArrayList();
        int[] res;
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        res = list.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }

    // 双向链表
    public int[] linkListToArray(TreeNode treeNode){
        List<Integer> list = new ArrayList();
        int[] res;
        while (treeNode != null){
            list.add(treeNode.val);
            treeNode = treeNode.right;
        }
        res = list.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }

    /************************斐波那契数列************************/
    /**
     * @param n 项数
     * @param first 第一项
     * @param second 第二项
     * @return 斐波那契数列
     */
    public int[] fibonacci(int n, int first, int second){
        int[] f = new int[n];
        f[0] = first;
        f[1] = second;
        for(int i = 2; i < n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
}
