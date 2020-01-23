package swordOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @ClassName SwordOffer_06
 * @Description:
 * 第6题
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入
 * 前序遍历序列{1,2,4,7,3,5,6,8}和
 * 中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 * @Author UESTC-ZKX
 * @Date 2020/1/22
 **/
public class SwordOffer_06 extends MyClass{
    // 工具类
    MyUtils myUtils = new MyUtils();
    // 分割左右子树法
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(myUtils.isNull(pre,in) || pre.length == 0){
            return null;
        }

        // 递归终止条件
        if(pre.length == 1){
            return new TreeNode(pre[0]);
        }
        // 将输入的int数组转为List
        ArrayList<Integer> preList = (ArrayList<Integer>) Arrays.stream(pre)
                .boxed().collect(Collectors.toList());
        ArrayList<Integer> inList = (ArrayList<Integer>) Arrays.stream(in)
                .boxed().collect(Collectors.toList());
        // 初始化根节点，根节点为前序第一个
        TreeNode root = new TreeNode(pre[0]);
        // 获取中序中根节点的位置
        int rootIndex = inList.indexOf(pre[0]);

        // 左子树序列
        int[] leftIn = inList.subList(0, rootIndex).stream()
                .mapToInt(Integer::valueOf).toArray();
        int[] leftPre = preList.subList(1,rootIndex+1).stream()
                .mapToInt(Integer::valueOf).toArray();
        // 右子树序列
        int[] rightIn = inList.subList(rootIndex+1, in.length)
                .stream().mapToInt(Integer::valueOf).toArray();
        int[] rightPre = preList.subList(rootIndex+1, pre.length)
                .stream().mapToInt(Integer::valueOf).toArray();

        // 开始递归
        root.left = reConstructBinaryTree(leftPre,leftIn);
        root.right = reConstructBinaryTree(rightPre,rightIn);
        return root;
    }






}
