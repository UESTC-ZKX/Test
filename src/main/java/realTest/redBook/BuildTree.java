package realTest.redBook;

import java.util.*;

/**
 * @ClassName BuildTree
 * @Description: 给定二叉树T（树深度不超过H<=10，深度从1开始，节点个数N<1024，节点编号1~N）
 * 的层序和中序遍历，输出T从左向右叶子节点以及树先序和后序遍历序列
 * <p>
 * 输入描述:
 * 输入两行，分别代表层序和中序遍历结果，节点编号按单个空格分开
 * <p>
 * 输出描述:
 * 依次输出  从左向右叶子节点 ，先序， 后序 遍历 。 节点编号按空格分开
 * <p>
 * 输入例子1:
 * 3 5 4 2 6 7 1
 * 2 5 3 6 4 7 1
 * <p>
 * 输出例子1:
 * 2 6 1
 * 3 5 2 4 6 7 1
 * 2 5 6 1 7 4 3
 * @Author UESTC-ZKX
 * @Date 2020/2/25
 **/
public class BuildTree {
    // 树节点
    class TreeNode {
        String val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(String val) {
            this.val = val;
        }
    }

    private List<String> leaveNode = new ArrayList<>();
    private List<String> pre = new ArrayList<>();
    private List<String> post = new ArrayList<>();

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        Scanner scanner = new Scanner(System.in);
        String[] level = scanner.nextLine().split(" ");
        String[] in = scanner.nextLine().split(" ");
        scanner.close();
        if (level.length < 1 || level.length != in.length) {
            return;
        }
        TreeNode root = buildTree.build(level, in);

        buildTree.preTraversal(root);
        buildTree.postTraversal(root);

        StringBuilder res1 = new StringBuilder();
        StringBuilder res2 = new StringBuilder();
        StringBuilder res3 = new StringBuilder();
        for (String s : buildTree.leaveNode) {
            res1.append(s).append(" ");
        }
        for (String s : buildTree.pre) {
            res2.append(s).append(" ");
        }
        for (String s : buildTree.post) {
            res3.append(s).append(" ");
        }
        System.out.println(res1.deleteCharAt(res1.length() - 1) + "");
        System.out.println(res2.deleteCharAt(res2.length() - 1) + "");
        System.out.println(res3.deleteCharAt(res3.length() - 1) + "");
    }

    private TreeNode build(String[] level, String[] in) {
        if (level == null || level.length < 1 || level.length != in.length) {
            return null;
        }
        TreeNode treeNode = new TreeNode(level[0]);
        if (level[0] == null) {
            return null;
        }
        int mid = 0;
        for (int i = 0; i < in.length; i++) {
            if (level[0].equals(in[i])) {
                mid = i;
                break;
            }
        }
        String[] leftIn = new String[mid];
        String[] rightIn = new String[in.length - mid];
        String[] leftLevel = new String[mid];
        String[] rightLevel = new String[in.length - mid];
        int a = 0, b = 0;
        for (int i = 0; i < in.length; i++) {
            if (i < mid) {
                leftIn[a++] = in[i];
            }
            if (i > mid) {
                rightIn[b++] = in[i];
            }
        }

        HashSet<String> leftInSet = new HashSet<>(Arrays.asList(leftIn));
        HashSet<String> rightInSet = new HashSet<>(Arrays.asList(rightIn));

        a = 0;
        b = 0;
        for (String s : level) {
            if (leftInSet.contains(s)) {
                leftLevel[a++] = s;
            }
            if (rightInSet.contains(s)) {
                rightLevel[b++] = s;
            }
        }
        treeNode.left = build(leftLevel, leftIn);
        treeNode.right = build(rightLevel, rightIn);
        if (treeNode.left == null && treeNode.right == null) {
            leaveNode.add(treeNode.val);
        }
        return treeNode;
    }

    private void preTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        pre.add(treeNode.val);
        preTraversal(treeNode.left);
        preTraversal(treeNode.right);
    }

    private void postTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postTraversal(treeNode.left);
        postTraversal(treeNode.right);
        post.add(treeNode.val);
    }
}
